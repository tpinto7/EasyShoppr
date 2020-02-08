package com.boylegu.springboot_vue.PasswordEncryption;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

//import javax.annotation.PostConstruct;

/**
 * Adopted from
 * http://www.javacodegeeks.com/2012/05/secure-password-storage-donts
 * -dos-and.html. Changes and reasoning explained at
 * http://alexwendland.com/blog/2013/07/java-servlet-secure-password-storage.
 *
 * @author Jerry Orr
 * @author Alex Wendland
 *
 */
public class PasswordEncryptionService {

    /**
     * Compares the ClearText password and stored salt to the stored, encrypted
     * password
     *
     * @param attemptedPassword
     *            - ClearText password to check
     * @param encryptedPassword
     *            - Stored password to compare against
     * @param salt
     *            - Stored salt used to generate the encryptedPassword
     * @return true if ClearText password is the same as the stored password
     */
    public static boolean authenticate(String attemptedPassword,
                                       byte[] encryptedPassword, byte[] salt) {
        // Encrypt the clear-text password using the same salt that was used to
        // encrypt the original password
        byte[] encryptedAttemptedPassword = getEncryptedPassword(
                attemptedPassword, salt);

        // Authentication succeeds if encrypted password that the user entered
        // is equal to the stored hash
        return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
    }

    /**
     * Generates a hash from the supplied password and salt (see
     * {@link PasswordEncryptionService#generateSalt()}) using the PBKDF2 with
     * SHA-1 algorithm
     *
     * @param password
     *            - Password to hash
     * @param salt
     *            - Salt to use for the hashing
     * @return - Password hash
     */
    public static byte[] getEncryptedPassword(String password, byte[] salt) {
        try {
            // PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
            // specifically names SHA-1 as an acceptable hashing algorithm for
            // PBKDF2
            String algorithm = "PBKDF2WithHmacSHA1";
            // SHA-1 generates 160 bit hashes, so that's what makes sense here
            int derivedKeyLength = 160;
            // Pick an iteration count that works for you. The NIST recommends
            // at
            // least 1,000 iterations:
            // http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
            // iOS 4.x reportedly uses 10,000:
            // http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/
            int iterations = 20000;

            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt,
                    iterations, derivedKeyLength);

            SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

            return f.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            /*
             * This should only happen when running this code on a new
             * environment. It will never happen unpredictably and therefore is
             * caught here so that utilizing code doesn't require a try/catch
             * block.
             */
            e.printStackTrace();
        }
        catch ( NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Generate a random salt using {@link SecureRandom}
     *
     * @return - Randomly generated 64-bit salt
     * @throws NoSuchAlgorithmException
     *             - Used to, now just caught and absorbed. Shouldn't happen in
     *             production ever
     */
    public static byte[] generateSalt() {
        try {
            // VERY important to use SecureRandom instead of just Random
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

            // Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
            byte[] salt = new byte[8];
            random.nextBytes(salt);

            return salt;
        } catch (NoSuchAlgorithmException e) {
            /*
             * This should only happen when running this code on a new
             * environment. It will never happen unpredictably and therefore is
             * caught here so that utilizing code doesn't require a try/catch
             * block.
             */
            e.printStackTrace();
        }
        return null;
    }
}

package ALLie_AutoTests;

import com.ic360.tests.framework.AutoTest;
import com.ic360.tests.framework.helpers.MailReader;
import com.ic360.tests.ui.web.alliehome.WebTestsConfig;
import org.apache.logging.log4j.LogManager;
import ru.yandex.qatools.allure.annotations.Step;

import javax.mail.Folder;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Implements Email robot actions.
 * Created by Leonid Samarkin on 02.12.2015.
 * ATTENTION: in case of error "Please log in via your web browser" see:
 * https://support.google.com/accounts/answer/6010255
 * https://www.google.com/settings/u/2/security/lesssecureapps
 */
public class EmailBot extends AutoTest{
    private String user_mailbox;

    public EmailBot(String user_mailbox) {
        this.user_mailbox = user_mailbox;
        log = LogManager.getLogger(EmailBot.class);
    }

    @Step("Get account activation URL from email")
    public String getAccountActivationUrl(String message_subject) {
        log.info(String.format("Going to read account confirmation email: mailbox = %s  subject= %s",
                user_mailbox,  message_subject));

        MailReader mailReader = new MailReader(emailConfig);
        Folder folder = mailReader.openMailbox();

        String url="";
        try {
            url = MailReader.waitForMessageWithUrl(folder, user_mailbox, message_subject, WebTestsConfig.Email.timeout_email_delivery_fast);
            if (folder.isOpen()) folder.close(true);
            folder.getStore().close();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            e.printStackTrace();
            fail(e.getLocalizedMessage());
        }

        log.info(String.format("Mailbox= %s subject= %s URL extracted= %s", user_mailbox, message_subject, url));


        assertTrue("Confirmation URL is empty!", url.length() > 0);

        return url;
    }


    @Step("Check pre-order email contains correct confirmation number")
    public boolean checkPreOrderConfirmationReceived(String confirmationNumber) {
        final String message_subject = "ALLie order confirmation"; //We are using constant email subject for Preorder

        MailReader mailReader = new MailReader(emailConfig);
        Folder folder = mailReader.openMailbox();

        boolean found = false;
        try {
            found = mailReader.waitForMessageWithText(
                    folder, user_mailbox, message_subject, confirmationNumber,
                    WebTestsConfig.Email.timeout_email_delivery_fast);

            if (folder.isOpen())
                folder.close(true);
            folder.getStore().close();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            e.printStackTrace();
            fail(e.getLocalizedMessage());
        }

        assertTrue("Confirmation mail was not received in a proper time", found);

        log.debug(String.format("Confirmation mail for order %s is received", confirmationNumber));

        return true;
    }

}


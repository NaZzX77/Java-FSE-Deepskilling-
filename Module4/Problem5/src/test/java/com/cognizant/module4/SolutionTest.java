package com.cognizant.module4;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SolutionTest {
    @Test
    public void testNotifyCustomerSendsEmail() {
        EmailService emailService = mock(EmailService.class);
        Solution solution = new Solution(emailService);

        solution.notifyCustomer("user@example.com");

        verify(emailService).sendEmail("user@example.com", "Your account has been updated");
    }
}

package org.jtesttools.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SendEmailTest {

    @Mock
    SendEmail sendEmail;

    @InjectMocks
    EmailService service;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void sendMail() {
        when(sendEmail.send("Teste")).thenReturn(true);

        boolean sent = service.sendEmail("Teste");

        assertThat(sent).isTrue();
    }

}

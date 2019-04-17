package org.jtesttools.demo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class SendEmailTest {

    @Mock
    SendEmail sendEmail;

    @InjectMocks
    EmailService service;

    @Test
    void whenSendMailThenReturnTrue() {
        Mockito.when(sendEmail.send("Teste")).thenReturn(true);

        boolean sent = service.sendEmail("Teste");

        Assertions.assertThat(sent).isTrue();
    }


    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

}

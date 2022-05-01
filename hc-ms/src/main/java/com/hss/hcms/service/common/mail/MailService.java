package com.hss.hcms.service.common.mail;

import java.util.List;

import com.hss.hcms.config.constants.MailBox;


public interface MailService {

	void send(String[] eMail, String subject, String content, String fileLocation, MailBox mode);

	void send(List<String> eMail, String subject, String content, String fileLocation, MailBox mode);

	void send(String eMail, String subject, String content, String fileLocation, MailBox mode);

}

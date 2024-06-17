private void gonderEmailTekli(String email, String konu, String mesaj) {
	
		
				senderEmail = "mail@gmail.com";
				emailPassword = "mailapppasword";
				yurtAdi = "name"
				yurtTelNo = "number";
		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, emailPassword);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(konu);
			message.setText(mesaj);

			Transport.send(message);

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					JOptionPane.showMessageDialog(null, email + " adresine mail gönderildi.", "Başarılı",
							JOptionPane.INFORMATION_MESSAGE);
					aramaText.setText("");
					textField.setText("");
					basliktextfield.setText("");
					textArea.setText("");
				}
			});
		} catch (MessagingException e) {
			e.printStackTrace();
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					JOptionPane.showMessageDialog(null, "Mail gönderilirken bir hata oluştu.", "Hata",
							JOptionPane.ERROR_MESSAGE);
				}
			});
		}
	}



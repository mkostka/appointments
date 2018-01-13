INSERT INTO public.role(
	id, role)
	VALUES (1, 'ADMIN');
INSERT INTO public.role(
	id, role)
	VALUES (2, 'USER');
INSERT INTO public.registered_user(
	id, active, email, name, last_name, password)
	VALUES (1, 1, 'test@test.test', 'Mr', 'Test',
	 '$2a$10$Ahzm2F2vMjx6/EqJsQfIM.wv6fsQe6H42JU7nNZjZRRNOsF/XKl.e');
INSERT INTO public.user_role(
	user_id, role_id)
	VALUES (1, 1);
INSERT INTO public.user_role(
	user_id, role_id)
	VALUES (1, 2);
	
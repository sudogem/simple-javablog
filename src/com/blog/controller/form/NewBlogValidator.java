package com.blog.controller.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.form.NewBlogForm;
import com.blog.util.StringUtils;

@SuppressWarnings("unchecked")
public class NewBlogValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(NewBlogForm.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		NewBlogForm form = (NewBlogForm) object;
		String title = form.getTitle();
		String blog = form.getBlog();
		
		if (StringUtils.isEmpty(title))
			errors.reject("error.nullpointer", "Title cannot be empty.");
		if (StringUtils.isEmpty(blog))
			errors.reject("error.nullpointer", "Blog cannot be empty.");
	}
	
}

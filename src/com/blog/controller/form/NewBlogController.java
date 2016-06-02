package com.blog.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.blog.entity.Blog;
import com.blog.form.NewBlogForm;
import com.blog.helper.Key;
import com.blog.service.IBlogManager;
import com.blog.util.RequestUtils;

public class NewBlogController extends SimpleFormController {

	private IBlogManager blogManager;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		NewBlogForm form = (NewBlogForm) command;
		int userId = (Integer) request.getSession().getAttribute(Key.USER_ID);
		blogManager.saveBlog(form, userId);
		
		return new ModelAndView("redirect:userConsole.do");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		int blogId = RequestUtils.getParam(request, "blog_id", 0);
		
		NewBlogForm form = new NewBlogForm();
		if (blogId > 0) {
			int userId = (Integer) request.getSession().getAttribute(Key.USER_ID);
			Blog blog = blogManager.getBlog(blogId, userId);
			if (blog != null) {
				form.setId(blog.getId());
				form.setTitle(blog.getTitle());
				form.setBlog(blog.getBlog());
			}
		}
		
		return form;
	}

	public IBlogManager getBlogManager() {
		return blogManager;
	}

	public void setBlogManager(IBlogManager blogManager) {
		this.blogManager = blogManager;
	}

}

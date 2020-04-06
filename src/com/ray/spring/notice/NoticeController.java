package com.ray.spring.notice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam("searchType") String type, 
			@RequestParam("search") String keyword) {
		
		List<Notice> ans = new ArrayList<Notice>();
		switch(type) {
			case "title":
				ans = noticeService.searchByTitle(keyword);
				break;
			case "author":
				ans = noticeService.searchByAuthor(keyword);
				break;
			default:
				break;
		}
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listNotice", ans);
		return mv;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("detail");
		Notice notice = noticeService.get(id);
		int view = notice.getView();
		view++;
		notice.setView(view);
		noticeService.create(notice);
		mv.addObject("notice", notice);
		return mv;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView home() {
	    List<Notice> listNotice = noticeService.listAll();
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("listNotice", listNotice);
	    return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String deleteNotice(@RequestParam("del-id") int[] ids) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i : ids) {
			list.add(i);
		}
		List<Notice> result = noticeService.getById(list);
		noticeService.deleteAll(result);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newNotice() {
		return "create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNotice(@RequestParam("title") String title, 
			@RequestParam("content") String content, @RequestParam("file") String file) {
		Date date = new Date();
		String file_path = "";
		int view = 0;
		
		Notice notice = new Notice(title, content, "Admin", date, view, file, file_path);
		noticeService.create(notice);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editNotice(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("edit");
		Notice notice = noticeService.get(id);
		mv.addObject("notice", notice);
		return mv;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateNotice(@RequestParam("id") int id, 
			@RequestParam("title") String title, 
			@RequestParam("content") String content, @RequestParam("file") String file) {
		
		Notice notice = noticeService.get(id);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setFile_name(file);
		noticeService.create(notice);
		
		return "redirect:/list";
	}
	
}

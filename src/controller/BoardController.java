package controller;

import javax.servlet.http.HttpSession;

import logic.BoardDto;
import logic.Cart;
import logic.Item;
import logic.ItemSet;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDaoImpl;
import utils.WebConstants;

@Controller
public class BoardController {

	@Autowired
	private Shop shopService;
	
	@Autowired
	private BoardDaoImpl boardDaoImpl;
	
	@ModelAttribute
	public BoardDto setUpForm(){
		BoardDto boardDto = new BoardDto();
		return boardDto;
	}

	@RequestMapping(value = "/board/boardList.html")
	public ModelAndView boardList() {
		ModelAndView view = new ModelAndView();
		view.setViewName("board/boardList");
		return view;
	}
	
	@RequestMapping(value = "/board/write.html", method=RequestMethod.GET)
	public ModelAndView boardWriteForm() {
		ModelAndView view = new ModelAndView();
		view.setViewName("board/write");
		return view;
	}
	
	@RequestMapping(value = "/board/write.html", method=RequestMethod.POST)
	public ModelAndView boardWrite(BoardDto boardDto) {
		boardDaoImpl.write(boardDto);
		ModelAndView view = new ModelAndView();
		view.setViewName("board/boardList");
		return view;
	}
}
package dao;

import java.util.List;

import logic.BoardDto;

public interface BoardDao {
	void write(BoardDto boardDto);
	
	BoardDto read(int no);
	
	List boardList();
}

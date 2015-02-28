package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logic.BoardDto;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String boardList = "SELECT * FROM board ORDER BY no";
	
	private static final String read = "SELECT * FROM board WHERE no=?";
	
	private static final String write = "INSERT INTO board(title, writerName, content, regdate)"
			+ " VALUES(:title, :writerName, :content, now())";
	
	private static final String delete = "DELETE FROM board WHERE no=?";
	
	private SimpleJdbcTemplate template;
	
	private SimpleJdbcInsert insertEmp;
	
	public void setDataSource(DataSource dataSource){
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	

	public void write(BoardDto boardDto) {
		/*Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", boardDto.getTitle());
		param.put("content", boardDto.getContent());
		param.put("writerName", boardDto.getWriterName());
		insertEmp.execute(param);*/
		/*this.template.update("INSERT into board(title, writerName, content, regdate)"
				+ " VALUES('1', '2', '3', now())");*/
		 String sql = "INSERT INTO board (title, writerName, content, regdate) VALUES(?,?,?,now())";
         
	        this.template.update( sql, 
	                            new Object[]{ boardDto.getTitle(),boardDto.getWriterName(),boardDto.getContent()});
	}

	public BoardDto read(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BoardDto> boardList() {
		org.springframework.jdbc.core.RowMapper<BoardDto> mapper = new BeanPropertyRowMapper<BoardDto>(BoardDto.class);
		return this.template.query(boardList, mapper);
	}
	
	public void delete(int no){
		
	}

}

package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
// @Service는 계층 구조상주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용한다.
@AllArgsConstructor
// 모든 파라미터를 이용하는 생성자를 만든다.
// BoardMapper를 주입받는 생성자가 만들어지게 된다.
public class BoardServiceImpl implements BoardService
{
	// 스프링 4.3부터는 단일 파라미터를 받는 생성자의 경우에는 필요한 파라미터를 자동으로 주입할 수 있다.

	@Setter(onMethod_ = @Autowired)
	// @Autowired와 같이 직접 설정해 줄 수 있고, Setter를 이용해서 처리할 수도 있다.
	// Lombok을 이용한다면 @Setter와 같은 방식으로 만들수도 있다.
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {

		log.info("register......" + board);

		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {

		log.info("get......" + bno);

		return mapper.read(bno);

	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("modify......" + board);

		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {

		log.info("remove...." + bno);

		return mapper.delete(bno) == 1;
	}

	// @Override
	// public List<BoardVO> getList() {
	//
	// log.info("getList..........");
	//
	// return mapper.getList();
	// }

	@Override
	public List<BoardVO> getList(Criteria cri) {

		log.info("get List with criteria: " + cri);

		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {

		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

}

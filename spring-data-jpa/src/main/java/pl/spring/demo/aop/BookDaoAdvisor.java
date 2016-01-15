package pl.spring.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.impl.BookDaoImpl;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.BookTo;
import pl.spring.demo.to.IdAware;

@Aspect
@Component
public class BookDaoAdvisor {
	private Sequence sequence;
	@Before("@annotation(pl.spring.demo.annotation.NullableId) && args(idAware,..)")
	private void checkNotNullId1(IdAware idAware) {
		if (idAware.getId() != null) {
			throw new BookNotNullIdException();
		}
	}
	
	@Before("@annotation(pl.spring.demo.annotation.NullableId) && args(idAware,..)")
	private void checkNotNullId(IdAware idAware) {
		if ((idAware.getClass().toString().contains("BookEntity")||idAware.getClass().toString().contains("BookTo")) && idAware.getId() == null) {
			((BookTo)idAware).setId(sequence.nextValue(new BookDaoImpl().findAll()));
		}
		if (idAware.getId() != null) {
			throw new BookNotNullIdException();
		}
	}


}

package eu.vytenis.hamcrest.sqlmatchers;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.gibello.zql.ZInsert;
import org.gibello.zql.ZQuery;
import org.junit.Test;

public class SqlMatcherTest {
	@Test
	public void matchesValidSelect() {
		assertThat("select * from dual", isSelect());
	}

	@Test
	public void doesNotMatchInvalidSelect() {
		assertThat("select *, from dual", not(isSelect()));
	}

	@Test
	public void matchesValidInsert() {
		assertThat("insert into mytable values(1)", isInsert());
	}

	@Test
	public void doesNotMatchInvalidInsert() {
		assertThat("insert into table", not(isInsert()));
	}

	private SqlMatcher isSelect() {
		return new SqlMatcher(ZQuery.class);
	}

	private SqlMatcher isInsert() {
		return new SqlMatcher(ZInsert.class);
	}
}
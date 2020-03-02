package com.swia.iavd;

import com.swia.iavd.model.Card;
import com.swia.iavd.model.CardMock;
import com.swia.iavd.model.CardSystem;
import com.swia.iavd.model.CardType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ResourceHelperTest {

	@Test
	void test_valid_resource() throws IOException {
		String content = ResourceHelper.getResourceContent(CardSystem.IACP, CardType.COMMAND);
		assertNotNull(content);
	}

	@Test
	void test_invalid_resource() throws IOException {
		try {
			ResourceHelper.getResourceContent("invalid_file");
		} catch (NullPointerException e) {
			return;
		}
		fail("IllegalArgumentException expected");
	}
	
}

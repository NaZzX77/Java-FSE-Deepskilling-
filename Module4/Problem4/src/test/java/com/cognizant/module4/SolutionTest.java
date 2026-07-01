package com.cognizant.module4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SolutionTest {
    @Test
    public void testFetchDataUsesMockedApi() {
        ExternalApi externalApi = mock(ExternalApi.class);
        when(externalApi.getData()).thenReturn("Mock Data");
        Solution solution = new Solution(externalApi);

        String result = solution.fetchData();

        assertEquals("Mock Data", result);
    }
}

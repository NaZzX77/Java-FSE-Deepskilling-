package com.cognizant.module4;

public class Solution {
    private final ExternalApi externalApi;

    public Solution(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}

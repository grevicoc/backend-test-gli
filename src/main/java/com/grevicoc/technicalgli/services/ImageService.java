package com.grevicoc.technicalgli.services;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface ImageService {
    Map<String, List<String>> getImagesOf(String breed) throws ExecutionException, InterruptedException;
}

package com.grevicoc.technicalgli.outbounds;

import java.util.List;
import java.util.Map;

public interface DogClient {
    BaseResponse<Map<String, List<String>>> getAllBreeds();
    BaseResponse<List<String>> getImagesByBreed(String breed);
    BaseResponse<List<String>> getImagesBySubBreed(String breed, String subBreed);
    BaseResponse<List<String>> getSubBreedsByBreed(String breed);
    BaseResponse<String> getRandomImage();
    BaseResponse<String> getRandomImageByBreed(String breed);
    BaseResponse<String> getRandomImageBySubBreed(String breed, String subBreed);
}

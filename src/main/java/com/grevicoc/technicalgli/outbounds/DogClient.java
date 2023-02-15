package com.grevicoc.technicalgli.outbounds;

import java.util.HashMap;
import java.util.List;

public interface DogClient {
    BaseResponse<HashMap<String, List<String>>> getAllBreeds();
    BaseResponse<List<String>> getImagesByBreed(String breed);
    BaseResponse<List<String>> getSubBreedsByBreed(String breed);
    BaseResponse<String> getRandomImage();
    BaseResponse<String> getRandomImageByBreed(String breed);
}

package com.grevicoc.technicalgli.services.impl;

import com.grevicoc.technicalgli.models.Dog;
import com.grevicoc.technicalgli.models.FactoryDog;
import com.grevicoc.technicalgli.models.dao.Breed;
import com.grevicoc.technicalgli.models.dao.Image;
import com.grevicoc.technicalgli.outbounds.BaseResponse;
import com.grevicoc.technicalgli.outbounds.DogClient;
import com.grevicoc.technicalgli.repositories.ImageRepository;
import com.grevicoc.technicalgli.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Component
public class ImageServiceImpl implements ImageService {
    @Autowired
    private DogClient dogClient;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Map<String, List<String>> getImagesOf(String breed) throws ExecutionException, InterruptedException {
        Map<String, List<String>> retval = new HashMap<>();
        FactoryDog factoryDog = FactoryDog.getInstance();

        if (Objects.equals(breed, "terrier")){
            try{
                BaseResponse<List<String>> responseSubBreeds = dogClient.getSubBreedsByBreed(breed);

                List<CompletableFuture<BaseResponse<List<String>>>> listOfCompletableFuture = new ArrayList<>();
                for (String subBreed: responseSubBreeds.getMessage()){
                    CompletableFuture<BaseResponse<List<String>>> futureResponseImages = CompletableFuture
                            .supplyAsync(() -> dogClient.getImagesBySubBreed(breed, subBreed));
                    listOfCompletableFuture.add(futureResponseImages);
                }

                CompletableFuture<Void> allFuture = CompletableFuture.allOf(listOfCompletableFuture
                        .toArray(new CompletableFuture[listOfCompletableFuture.size()]));
                CompletableFuture<List<BaseResponse<List<String>>>> listAllFuture = allFuture.thenApply(v ->
                        listOfCompletableFuture.stream().map(future -> future.join())
                                .collect(Collectors.toList()));
                List<BaseResponse<List<String>>> results = listAllFuture.get();

                int idx = 0;
                for (BaseResponse<List<String>> response: results){
                    retval.put("terrier-" + responseSubBreeds.getMessage().get(idx), response.getMessage());
                    idx++;
                }

                return retval;
            }catch (Exception e){
                throw e;
            }
        }else{
            try{
                BaseResponse<List<String>> responseImages = dogClient.getImagesByBreed(breed);
                Dog tempDog = factoryDog.createDog(breed, new ArrayList<>(), responseImages.getMessage());
                retval.put(breed, tempDog.getImages());

                return retval;
            }catch (Exception e){
                List<Image> imagesDAO = imageRepository.findAllByBreed_Name(breed);
                List<String> images = imagesDAO.stream().map(image -> image.getSource()).collect(Collectors.toList());
                retval.put(breed, images);

                return retval;
            }
        }
    }
}

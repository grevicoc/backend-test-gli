# Backend Technical Test Project
A Project to fullfill technical test as a Backend Developer at GLI.

## Requirements
- Maven 3.9.0
- Java 1.8.0_202

## How to Run
1. Open this project on IntelliJ and change the SDK we want to use to 1.8.0-202
2. Download the dependencies that we need.
3. Run the program.

## Quick Documentation
``GET | localhost:8080/dog``<br>
Will return all of dogs from outbound api and our database. <br><br>
``GET | localhost:8080/dog/{breed}/images``
Will return all of images from dog that we specified its breed. <br><br>
``POST | localhost:8080/dog`` <br>
``Request Body = breed: string, sub_breeds: list of string, images: list of string `` <br>
Will not return anything, but just some message that give information the operation post is success. <br><br>
``PUT | localhost:8080/dog/{id}`` <br>
``Request Body = breed: string, sub_breeds: list of string, images: list of string `` <br>
Will not return anything, but just some message that give information the operation updating dog with id X is success. <br><br>
``DELETE | localhost:8080/dog/{id}`` <br>
Will not return anything, but just some message that give information the operation delete is success.<br><br>

## Created by
Muhammad Tito Prakasa (grevi)
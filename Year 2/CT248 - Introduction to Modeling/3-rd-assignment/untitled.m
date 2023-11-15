clear;
pic = imread('Engineering-Building.jpg');

GrayScale = pic2grayscale(pic);

transformed_image = transform_pic(GrayScale);

T_50 = transform_threshold(GrayScale, 50);
T_75 = transform_threshold(GrayScale, 75);
T_100 = transform_threshold(GrayScale, 100);

subplot(3, 2, 1); imshow(pic); title('Original');
subplot(3, 2, 2); imshow(GrayScale); title('Grayscale');
subplot(3, 2, 3); imshow(transformed_image); title('Transformed');
subplot(3, 2, 4); imshow(T_50); title('Binary Threshold 50');
subplot(3, 2, 5); imshow(T_75); title('Binary Threshold 75');
subplot(3, 2, 6); imshow(T_100); title('Binary Threshold 100');



function T_picture = transform_threshold(pic, T)
    T_picture = pic >= T;
end


function picture = pic2grayscale(RGB_IMAGE)
    alpha = 0.2989;
    beta = 0.5870;
    gamma = 0.1140;

    picture = alpha * RGB_IMAGE(:,:,1) + beta * RGB_IMAGE(:,:,2) + gamma * RGB_IMAGE(:,:,3);
    
end

function transformed_image = transform_pic(image)

    m = -255/255;
    b = 255;
    
    transformed_image = m*double(image) + b;
    
    transformed_image = uint8(transformed_image);

end
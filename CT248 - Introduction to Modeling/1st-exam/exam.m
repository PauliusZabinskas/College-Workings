
clear;


gr1 = create_grades(10,5,-10,110,100)

gr2 = clean_grades(gr1)

gr3= fill_estimates(gr2)



function x = fill_estimates(grades)

    

    for  i = grades(:,1)
        sum = grades(1);
    end
    x = i;
end

function x = clean_grades(grades)
    matrix = grades;
    if matrix(matrix > 100)
        matrix(matrix > 100) = 0;
    end
    if matrix(matrix < 0)
        matrix(matrix < 0) = 0;
    end
    

    x = matrix;
end

function x = create_grades (studNum, subNum, lowRange, uppRange, seed)
    rng(seed);
    x = randi([lowRange uppRange],[studNum, subNum]);
end
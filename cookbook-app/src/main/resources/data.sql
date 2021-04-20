INSERT INTO COOK VALUES (1, 'gipszjakab', 'password')
INSERT INTO COOK VALUES (2, 'palkata', '123456')

INSERT INTO RECIPE VALUES (1, 'Pea soup', 'Heat the oil in a saucepan over a medium heat. Add the onion and garlic and fry for
    34 minutes, until softened.
    Add the frozen peas and chicken or vegetable stock and bring to the boil. Reduce the
    heat and simmer for ten minutes.
    Add the cream and use a hand blender to liquidise the soup.
    Season, to taste and serve in a warm bowl, garnished with a mint leaf.', 2, 1)
INSERT INTO RECIPE VALUES (2, 'French onion soup', 'Cook the onions, stirring often, until they have softened, about 15 to 20 minutes.
    Add the vermouth to the pot and scrape up the browned bits on the bottom and sides of the pot, deglazing the pot as you go.
    Add the stock, bay leaves, and thyme. Bring to a simmer, cover the pot and lower the heat to maintain a low simmer. Cook for about 30 minutes.
    To serve, ladle soup into a bowl and transfer one cheesy toast onto the top of each bowl of soup.', 4, 2)

INSERT INTO RECIPE_CATEGORY VALUES (1, 'SOUP', 1)
INSERT INTO RECIPE_CATEGORY VALUES (2, 'SALTY', 1)
INSERT INTO RECIPE_CATEGORY VALUES (3, 'SOUP', 2)
INSERT INTO RECIPE_CATEGORY VALUES (4, 'SALTY', 2)

INSERT INTO INGREDIENT VALUES (1, 15.0, 'olive', 'MILLILITER', 1)
INSERT INTO INGREDIENT VALUES (2, 1.0, 'garlic', 'PIECE', 1)
INSERT INTO INGREDIENT VALUES (3, 0.5, 'onion', 'PIECE', 1)
INSERT INTO INGREDIENT VALUES (4, 200.0, 'peas', 'GRAM', 1)
INSERT INTO INGREDIENT VALUES (5, 300.0, 'chicken', 'MILLILITER', 1)
INSERT INTO INGREDIENT VALUES (6, 50.0, 'cream', 'MILLILITER', 1)
INSERT INTO INGREDIENT VALUES (7, 200.0, 'butter', 'GRAM', 2)
INSERT INTO INGREDIENT VALUES (8, 2.0, 'garlic', 'PIECE', 2)
INSERT INTO INGREDIENT VALUES (9, 10.0, 'onion', 'PIECE', 2)
INSERT INTO INGREDIENT VALUES (10, 10.0, 'olive', 'MILLILITER', 2)

INSERT INTO COMMENT VALUES (1, 'Very yummy.', '2021-01-08T15:30:39.881330200', 2, 1)
INSERT INTO COMMENT VALUES (2, 'Yes it is.', '2021-01-08T15:30:39.881330200', 1, 1)
INSERT INTO COMMENT VALUES (3, 'This is my favorite.', '2021-04-08T12:41:54.962018300', 1, 1)
INSERT INTO COMMENT VALUES (4, 'Very good soup.', '2021-04-08T14:49:33.793998500', 2, 2)
INSERT INTO COMMENT VALUES (5, 'Hmmmm', '2021-04-20T11:20:12.288212700', 1, 1)
/*This class is not part of the program, it only shows how the maps were manually created
MAP 1 DOUBLE SNAKE

map = new Block [15] [20];

for (int n = 0; n < 15; n++)
{
    map[n][0] = new Block ("Wall");
    map[n][19] = new Block ("Wall");
}
    
for (int m = 0; m < 20; m++)
{
    map[0][m] = new Block ("Wall");
    map[14][m] = new Block ("Wall");
}

for (int m = 2; m < 18; m++)
{
    if (m%2 == 0 )
            for (int n = 2; n < 7; n++)
            map [n][m] = new Block ("Wall");
    else
        for (int n = 8; n < 13; n++)
            map [n][m] = new Block ("Wall");
}

map[6][3] = new Block ("Crate");
map[6][7] = new Block ("Crate");
map[6][11] = new Block ("Crate");
map[6][15] = new Block ("Crate");

map[5][2] = new Block ("Crate");
map[6][3] = new Block ("Crate");
map[6][10] = new Block ("Crate");
map[6][14] = new Block ("Crate");


map[8][4] = new Block ("Crate");
map[8][8] = new Block ("Crate");
map[8][12] = new Block ("Crate");
map[8][16] = new Block ("Crate");

map[9][5] = new Block ("Crate");
map[9][9] = new Block ("Crate");
map[9][13] = new Block ("Crate");
map[9][17] = new Block ("Crate");

map[3][4] = new Block ("Crate");
map[3][8] = new Block ("Crate");
map[3][12] = new Block ("Crate");
map[3][16] = new Block ("Crate");

map[11][3] = new Block ("Crate");
map[11][7] = new Block ("Crate");
map[11][11] = new Block ("Crate");
map[11][15] = new Block ("Crate");

map[2][5] = new Block ("Crate");
map[2][9] = new Block ("Crate");
map[2][13] = new Block ("Crate");

map[12][6] = new Block ("Crate");
map[12][10] = new Block ("Crate");
map[12][14] = new Block ("Crate");

map[2][16] = new Block ("Crate");
map[12][3] = new Block ("Crate");

for (int n = 0; n < 15; n++)
    for (int m = 0; m < 20; m++)
        if (map[n][m] == null)
            map[n][m] = new Block ("Ground");

///////////////////////////////////////////
//Map2

map = new Block [15] [20];

int num = 1;
String str;
str = "";   
    
str = str + "wwwwwwwwwwwwwwwwwwww";
str = str + "w                  w";
str = str + "w w w w w  w w w w w";
str = str + "w                  w";
str = str + "w w w w w  w w w w w";
str = str + "w                  w";
str = str + "w w w w w  w w w w w";
str = str + "w                  w";
str = str + "w w w w w  w w w w w";
str = str + "w                  w";
str = str + "w w w w w  w w w w w";
str = str + "w                  w";
str = str + "w w w w w  w w w w w";
str = str + "w                  w";
str = str + "wwwwwwwwwwwwwwwwwwww";

String letter;
for (int n = 0; n < 15; n++)
    for (int m = 0; m < 20; m++)
    {
        letter = str.substring(num-1,num);
        
        if (letter.equals("w"))
            map[n][m] = new Block ("Wall");
        else if (letter.equals("c"))
            map[n][m] = new Block ("Crate");
        else
            map[n][m] = new Block ("Ground");            
        
        num++;    
    }




///////////////////////////////////////////
//Map3


map = new Block [15] [20];

int num = 1;
String str;
str = "";   

str = str + "wwwwwwwwwwwwwwwwwwww";
str = str + "w                  w";
str = str + "w ww  c  cc  c  ww w";
str = str + "w w              w w";
str = str + "w   w    cc    w   w";
str = str + "w c  w        w  c w";
str = str + "w     w      w     w";
str = str + "w c c  c cc c  c c w";
str = str + "w     w      w     w";
str = str + "w c  w        w  c w";
str = str + "w   w    cc    w   w";
str = str + "w w              w w";
str = str + "w ww  c  cc  c  ww w";
str = str + "w                  w";
str = str + "wwwwwwwwwwwwwwwwwwww";

String letter;
for (int n = 0; n < 15; n++)
    for (int m = 0; m < 20; m++)
    {
        letter = str.substring(num-1,num);
        
        if (letter.equals("w"))
            map[n][m] = new Block ("Wall");
        else if (letter.equals("c"))
            map[n][m] = new Block ("Crate");
        else
            map[n][m] = new Block ("Ground");            
        
        num++;    
    }




/////////////////////////////////////
//Map4

map = new Block [15] [20];

int num = 1;
String str;
str = "";   

str = str + "wwwwwwwwwwwwwwwwwwww";
str = str + "wc c            c cw";
str = str + "w  w cwwwcwwwwc w  w";
str = str + "w cw w        w wc w";
str = str + "w  w w cwcwwc w w  w";
str = str + "w  w w w    w w w  w";
str = str + "w  w w w ww w w w  w";
str = str + "w  c c c  c c c c  w";
str = str + "w  w w wwww w w w  w";
str = str + "w  w w      w w w  w";
str = str + "w  w cwwwcwwc w w  w";
str = str + "w cw          w wc w";
str = str + "w  wwwwwwcwwwwc w  w";
str = str + "wc c            c cw";
str = str + "wwwwwwwwwwwwwwwwwwww";


String letter;
for (int n = 0; n < 15; n++)
    for (int m = 0; m < 20; m++)
    {
        letter = str.substring(num-1,num);
        
        if (letter.equals("w"))
            map[n][m] = new Block ("Wall");
        else if (letter.equals("c"))
            map[n][m] = new Block ("Crate");
        else
            map[n][m] = new Block ("Ground");            
        
        num++;    
    }







/////////////////////////
//Map5


map = new Block [15] [20];

int num = 1;
String str;
str = "";   


str = str + "wwwwwwwwwwwwwwwwwwww";
str = str + "w                  w";
str = str + "w cc  wwcww     cc w";
str = str + "w c  w     w     c w";
str = str + "w   w       w      w";
str = str + "w  w  c   ww       w";
str = str + "w  w c   w         w";
str = str + "w  c c  w     cc   w";
str = str + "w  w c   w         w";
str = str + "w  w  c   ww       w";";
str = str + "w   w       w      w";
str = str + "w c  w     w     c w";
str = str + "w cc  wwcww     cc w";
str = str + "w                  w";
str = str + "wwwwwwwwwwwwwwwwwwww";


String letter;
for (int n = 0; n < 15; n++)
    for (int m = 0; m < 20; m++)
    {
        letter = str.substring(num-1,num);
        
        if (letter.equals("w"))
            map[n][m] = new Block ("Wall");
        else if (letter.equals("c"))
            map[n][m] = new Block ("Crate");
        else
            map[n][m] = new Block ("Ground");            
        
        num++;    
    }







///////////////////////////
//Map6


map = new Block [15] [20];

int num = 1;
String str;
str = "";   

str = str + "wwwwwwwwwwwwwwwwwwww";
str = str + "w                  w";
str = str + "w    c    w   c    w";
str = str + "w   c    c c   c   w";
str = str + "w  c    w   w   c  w";
str = str + "w c    w     w   c w";
str = str + "w     w ccccc w    w";
str = str + "w    w c     c w   w";
str = str + "w   w c   w   c w  w";
str = str + "w  w   c     c   w w";
str = str + "w c     ccccc     cw";
str = str + "w ccwwwwwwwwwwwwwccw";
str = str + "w                  w";
str = str + "w     c w c w c    w";
str = str + "wwwwwwwwwwwwwwwwwwww";

String letter;
for (int n = 0; n < 15; n++)
    for (int m = 0; m < 20; m++)
    {
        letter = str.substring(num-1,num);
        
        if (letter.equals("w"))
            map[n][m] = new Block ("Wall");
        else if (letter.equals("c"))
            map[n][m] = new Block ("Crate");
        else
            map[n][m] = new Block ("Ground");            
        
        num++;    
    }


///////////////////////////////////////////////////////////
//Map7

map = new Block [15] [20];

int num = 1;
String str;
str = "";   

str = str + "wwwwwwwwwwwwwwwwwwww";
str = str + "w           c    c w";
str = str + "w ccccccc ccc cc c w";
str = str + "w c   c c     c  c w";
str = str + "w   c c c ccccc cc w";
str = str + "wcccc c     c   c  w";
str = str + "w c   ccccc c ccc cw";
str = str + "w c     c   c   c cw";
str = str + "w c ccc c ccc ccc  w";
str = str + "w   c c c c     cc w";
str = str + "wcccc c cccc c  cc w";
str = str + "w     c      c  c  w";
str = str + "w cccccc ccccc ccc w";
str = str + "w        c         w";
str = str + "wwwwwwwwwwwwwwwwwwww";

String letter;
for (int n = 0; n < 15; n++)
    for (int m = 0; m < 20; m++)
    {
        letter = str.substring(num-1,num);
        
        if (letter.equals("w"))
            map[n][m] = new Block ("Wall");
        else if (letter.equals("c"))
            map[n][m] = new Block ("Crate");
        else
            map[n][m] = new Block ("Ground");            
        
        num++;    
    }

    
///////////////////////////////////////////////
//Map8

map = new Block [15] [20];

int num = 1;
String str;
str = "";   

str = str + "wwwwwwwwwwwwwwwwwwww";
str = str + "w                  w";
str = str + "w cccc www www ccc w";
str = str + "w c    w w w w   c w";
str = str + "w c c  w www w c c w";
str = str + "w c  c w     w c c w";
str = str + "w      w     w     w";
str = str + "w                  w";
str = str + "w wwww c   c wwww  w";
str = str + "w w  w  c c  w     w";
str = str + "w wwww   c   wwww  w";
str = str + "w w     c c     w  w";
str = str + "w w    c   c wwww  w";
str = str + "w        c         w";
str = str + "wwwwwwwwwwwwwwwwwwww";

String letter;
for (int n = 0; n < 15; n++)
    for (int m = 0; m < 20; m++)
    {
        letter = str.substring(num-1,num);
        
        if (letter.equals("w"))
            map[n][m] = new Block ("Wall");
        else if (letter.equals("c"))
            map[n][m] = new Block ("Crate");
        else
            map[n][m] = new Block ("Ground");            
        
        num++;    
    }
}
*/





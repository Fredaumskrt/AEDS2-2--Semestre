#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    char** arr;
    int len;
} StringArr;

typedef struct {
    char* s;
} Data;

typedef struct {
    int appID, age, dlcs, avgPT;
    float price, upvotes;
    bool windows, mac, l;
    Data date;
    char *name, *owners, *website, *developers; 
    StringArr languages, genres;
} Game;

void myparser();
void construct(StringArr arr);
int pickId(char* const s);
void alocateStrings(StringArr* strs, int len);
void freeStr(StringArr strs);

StringArr split(char* const s, char c);
int count(char* const s, char c);
char* parseData(char* s);
char* strtrim(char* const s);
void printTime(int t);
float myround(float x);
void toStringns(char** const arr, int len);
void printStrs(StringArr strs);
void printInts(int a[], int len);
bool isIn(int id, int arr[], int len);
size_t length(char* const s);
int parseInt(char* const s); 
bool isNumber(char c);
int expon(int b, int e);
bool equal(char* const s1, char* const s2);


int main(int argc, char* args) {
    myparser();
    return 0;
}

void myparser() {
    char* s = (char*)malloc(sizeof(char) * 1000);
    char* str = (char*)malloc(sizeof(char) * 1000);
    int ids[100];
    
    FILE* f = fopen("/tmp/games.csv", "r");
    if(f == NULL) {
        printf("error");
        exit(1);
    }

    fgets(s, 1000, stdin);
    s[length(s) - 1] = '\0';
    int k = 0;
    while(!equal(s, "FIM")) {
        ids[k] = parseInt(s);
        bool value = false;

        rewind(f);
        fgets(str, 1000, f);
        str[length(str)] = '\0';
        while(!feof(f) && !value) {
            value = pickId(str) == parseInt(s);
            if(value) 
                construct(split(str, ','));

            fgets(str, 1000, f);
            str[length(str)] = '\0';
        }

        fgets(s, 1000, stdin);
        s[length(s) - 1] = '\0';
        k++;
    }

    free(s);
    free(str);
    fclose(f);
}

void construct(StringArr arr) {

    Game g;
    g.appID = parseInt(arr.arr[0]);
    g.name = arr.arr[1];
    g.date.s = parseData(arr.arr[2]);
    g.owners = arr.arr[3];
    g.age = parseInt(arr.arr[4]);
    g.price = atof(arr.arr[5]);
    g.dlcs = parseInt(arr.arr[6]);
    g.languages = split(arr.arr[7], ',');
    g.website = arr.arr[8];
    g.windows = arr.arr[9][0] == 'T';
    g.mac = arr.arr[10][0] == 'T';
    g.l = arr.arr[11][0] == 'T';
    
    g.upvotes = myround((atof(arr.arr[12]) / (atof(arr.arr[13]) + atof(arr.arr[12]))) * 100);
    
    g.avgPT = parseInt(arr.arr[14]);
    g.developers = arr.arr[15];
    g.genres = split(arr.arr[16], ',');
    
    printf("%i %s %s %s %i %.2f %i ", g.appID, g.name, g.date.s, g.owners, g.age, g.price, g.dlcs);
    toStringns(g.languages.arr, g.languages.len);
    printf(" %s %s %s %s %i%% ", (length(g.website) == 0) ? "null" : g.website, g.windows ? "true" : "false", g.mac ? "true" : "false", g.l ? "true" : "false", (int)g.upvotes);
    printTime(g.avgPT);
    printf(" %s ", g.developers);
    printStrs(g.genres);

    free(g.date.s);
    freeStr(g.languages);
    freeStr(g.genres);
}

int pickId(char* const s) {
    char* str = (char*)malloc(sizeof(char) * 50);
    int len = length(s);

    int j = 0;
    for(int i = 0; i < len && s[i] != ','; i++) 
        str[j++] = s[i];

    str[j] = '\0';
    int res = parseInt(str);
    free(str);
    return res;
}

void alocateStrings(StringArr* strs, int len) {
    strs->len = len;
    strs->arr = (char**)malloc(sizeof(char*) * len);
    for(int i = 0; i < len; i++) strs->arr[i] = (char*)malloc(sizeof(char) * 1000);
}

void freeStr(StringArr strs) {
    for(int i = 0; i < strs.len; i++) free(strs.arr[i]);
    free(strs.arr);
}

StringArr split(char* const s, char c) { 
    int len = length(s),
        cont = count(s, c);
    StringArr strs;
    strs.len = cont + 1;
    strs.arr = (char**)malloc(sizeof(char*) * (cont + 1));
    char* str = (char*)malloc(sizeof(char) * 1000);

    int l = 0, m = 0, k = 0;
    for(int i = 0, j = 0; i < len; i++) {
        if(s[i] == 34) l++;
        else if(s[i] == 91 || s[i] == 93) m++;
        else if(s[i] != c || l % 2 != 0 || m % 2 != 0) {
            if((m % 2 != 0 && s[i] != 39) || m % 2 == 0)            
                str[j++] = s[i];
        } else {
            str[j] = '\0';
            strs.arr[k++] = str;
            str = (char*)malloc(sizeof(char) * 1000);
            j = 0;
            str[j] = '\0';
        }   
    }

    strs.arr[k] = str;
    return strs;
}

int count(char* const s, char c) {
    int qtd = 0,
        len = length(s);
    for(int i = 0, a = 0; i < len; i++) {
        if(s[i] == 34) a++;
        else if(s[i] == c && a % 2 == 0) qtd++;
    }
    
    return qtd;
}

char* parseData(char* s) {
    s = strtrim(s);
    int len = length(s);
    char* str = (char*)malloc(sizeof(char) * (len + 1));
    
    int i = 0;
    while(i < 3) {
        str[i] = s[i];
        i++;
    }
    str[i++] = '/';

    int j = len - 4;
    while(i < 8) {
        str[i++] = s[j];
        j++;
    }

    str[i] = '\0';
    return str;
}

char* strtrim(char* const s) {
    int len = length(s);
    char* str = (char*)malloc(sizeof(char) * (len + 1));
    
    int j = len - 1,
        i = 0;
    while(s[j] == ' ' || s[i] == ' ') {
        if(s[i] == ' ') i++;
        if(s[j] == ' ') j--;
    }

    int k = 0;
    while(i <= j) 
        str[k++] = s[i++];

    str[k] = '\0';
    return str;
}

void toStringns(char** const arr, int len) {
    printf("[");
    for(int i = 0; i < len; i++) {
        printf("%s", arr[i]);
        if(i != len - 1) printf(",");
    } 
    printf("]");
}

void printStrs(StringArr strs) {
    printf("[");
    for(int i = 0; i < strs.len; i++) {
        printf("%s", strs.arr[i]);
        if(i != strs.len - 1) printf(", ");
    }
    printf("]");
}

void printInts(int a[], int len) {
    printf("[");
    for(int i = 0; i < len; i++) {
        printf("%i", a[i]);
        if(i != len - 1) printf(", ");
    }
    printf("] ");
}

void printTime(int t) {
    int h = t / 60;
    int m = t % 60;

    if(h != 0 && m != 0) printf("%ih %im", h, m);
    else if(h == 0 && m != 0) printf("%im", m);
    else if(h != 0 && m == 0) printf("%ih", h);
    else printf("null");
}

bool isIn(int id, int arr[], int len) {
    bool value = false;
    int i = 0;
    while(!value && i < len) {
        value = arr[i] == id;
        i++;
    }
    return value;
}

bool equal(char* const s1, char* const s2) {
    int len1 = length(s1),
        len2 = length(s2);
    bool value = len1 == len2; 
    for(int i = 0; i < len1 && value; i++)
        value = s1[i] == s2[i];
    
    return value;
}

float myround(float x) {
    float dif = x - (float)((int)x);
    if(dif >= 0.5) x = (float)((int)x + 1);
    else x = (float)((int)x);
    return x;
}

int parseInt(char* const s) {
    int res = 0,
        len = length(s);
    for(int i = len - 1, j = 0; i >= 0; i--) {
        if(isNumber(s[i])) {
            res += ((int)s[i] - 48) * expon(10, j);
            j++;
        }
    }

    return res;
}

bool isNumber(char c) {
    return (int)c >= 48 && (int)c <= 57;
}

int expon(int b, int e) {
    int res = 1;
    for(int i = 0; i < e; i++) res *= b;
    return res;
}

size_t length(char* const s) {
    size_t i = 0;
    if(s != NULL) 
        while(s[i] != '\0') i++;
    return i;    
}

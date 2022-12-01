1. Розробити програму, яка на вхід отримує xml-файл з тегами <person>, в яких є атрибути name і surname.
Програма повинна створювати копію цього файлу, в якій значення атрибута surname об'єднане з name.
Наприклад name="Тарас" surname="Шевченко" у вхідному файлі повинно бути замінене на name="Тарас Шевченко" (атрибут surname має бути видалений).
Вхідний файл може бути великий, тому завантажувати його цілком в оперативну пам'ять буде поганою ідеєю.
* Опціонально (на макс. бал): зробити так, щоб форматування вихідного файла повторювало форматування вхідного файлу (мабуть, xml-парсер в такому разі тут не підійде).


Приклад вхідного файлу:
    
<persons>
    <person name="Іван" surname="Котляревський" birthDate="09.09.1769" />
    <person surname="Шевченко" name="Тарас" birthDate="09.03.1814" />
    <person
        birthData="27.08.1856"
        name = "Іван"
        surname = "Франко" />
    <person name="Леся"
            surname="Українка"
            birthData="13.02.1871" />
</persons>

Приклад вихідного файлу:
    
<persons>
    <person name="Іван Котляревський" birthDate="09.09.1769"  />
    <person name="Тарас Шевченко" birthDate="09.03.1814" />
    <person
        birthData="27.08.1856"
        name = "Іван Франко"
         />
    <person name="Леся Українка"

            birthData="13.02.1871" />
</persons>


2. У папці є перелік текстових файлів, кожен із яких є "зліпок" БД порушень правил дорожнього руху протягом певного року.
Кожен файл містить список json (або xml - на вибір) об'єктів - порушень приблизно такого виду:
{
    "date_time: "2020-05-05 15:39:03", // час порушеня
    "first_name": "Ivan",
    "last_name": "Ivanov"
    "type": "SPEEDING", // тип порушення
    "fine_amount": 340.00 // сума штрафу
}

Прочитати дані з усіх файлів, розрахувати та вивести статистику порушень у файл. В вихідному файлі повинні міститися загальні суми штрафів за кожним типом порушень за всі роки, відсортовані за сумою (спочатку за найбільшою сумою штрафу).
Якщо вхідний файл був json, то вихідний повиннен бути xml. Якщо вхідний xml, то вихідний - json. Щоб ви мали досвід роботи з обома форматами.
* Опціонально (на макс. бал): зробити так, щоб вхідні файли не завантажувалися цілком в пам'ять.

  
  1. Expand the program so that it takes an xml file with <person> tags as input, in which there are name and surname attributes.
It is the program's responsibility to make a copy of that file, in the same way that the value of the surname attribute is combined with the name.
For example, name="Taras" surname="Shevchenko" in the input file should be changed to name="Taras Shevchenko" (the surname attribute can be deleted).
The input file may be large, so it will be a bad idea to capture it in full in the operational memory.
* Optional (to max. score): make it so that the formatting of the output file repeats the formatting of the input file (probably, the xml-parser does not work here in this case).


Sample input file:
    
<persons>
     <person name="Ivan" surname="Kotlyarevsky" birthDate="09/09/1769" />
     <person surname="Shevchenko" name="Taras" birthDate="03/09/1814" />
     <person
         birthData="08/27/1856"
         name = "Ivan"
         surname = "Franco" />
     <person name="Lesia"
             surname="Ukrainian"
             birthData="02/13/1871" />
</persons>

Example output file:
    
<persons>
     <person name="Ivan Kotlyarevsky" birthDate="09/09/1769" />
     <person name="Taras Shevchenko" birthDate="03/09/1814" />
     <person
         birthData="08/27/1856"
         name = "Ivan Franko"
          />
     <person name="Lesia Ukrainian"

             birthData="02/13/1871" />
</persons>


2. The papacy has a copy of text files, skins from some of them "slips" of the database break the rules of the road traffic by stretching the song rock.
The skin file contains a list of json (or xml - on vibir) objects - a destruction of approximately the following form:
{
     "date_time: "2020-05-05 15:39:03", // hour of destruction
     "first_name": "Ivan",
     "last_name": "Ivanov"
     "type": "SPEEDING", // damage type
     "fine_amount": 340.00 // fine amount
}

Read the data from the saved files, unpack and enter the damage statistics for the file. In the final file, the total amount of fines for the skin type of damage is due for all ages, sorted for the sum (one for the largest amount of the fine).
If the input file is json, then the output is due to xml. If the input is xml, then the output is json. Shchob vy mali dosvid work with both formats.
* Optional (to the max. score): robite so that the input files are not completely captured in memory.

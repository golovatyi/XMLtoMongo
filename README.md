# XMLtoMongo

Данная программа выполняет поиск XML файлов в заданной папке, и получает данные для заполнения БД MongoDB. Выполнена в рамках курса СУБД в университете.

На вход подается полный путь до искомой папки, содержащий XML файл следующего вида:
```
<base>
  <note>Всп. время на совм-е профиля детали и инструмента. Зубострогальный п/авт.</note>
  <searchmask>////////////////</searchmask>
  <attrs>
    <attr>
      <name>Q.DSR</name>
      <mask>Описание базы</mask>
      <type>str</type>
    </attr>
    <attr>
      <name>Q.BASE</name>
      <mask>Имя базы</mask>
      <type>str</type>
    </attr>
    <attr>
      <name>Q.MASK</name>
      <mask>Маска для поиска</mask>
      <type>str</type>
    </attr>
    <attr>
      <name>Q.GBA</name>
      <mask>База графики</mask>
      <type>str</type>
    </attr>
  </attrs>
  <records>
    <record>
      <field0></field0>
      <field1>profil.dat</field1>
      <field2></field2>
      <field3></field3>
    </record>
  </records>
</base>
```

Где содержимое <mask></mask> - имя поля, <field[int]></field[int]> - значение поля mask[int], ```<note></note> ```- имя коллекции. 

При выполнении алгоритма создается коллекция, в неё добавляется (количество тегов ```<record>```) документов.

dependencies: mongodb-org, [MongoDB driver for Java](http://mongodb.github.io/mongo-java-driver/3.6/)



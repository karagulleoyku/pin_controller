# PROJE TANIMI
Bu proje, **Turing makinesi kuramını gerçek hayatla ilişkilendirmek** amacıyla yapılmıştır. Projede, kullanıcıdan alınan 4 haneli bir PIN kodunun, sistemde kayıtlı PIN koduyla eşleşip eşleşmediğini denetleyen bir **Turing makinesi simülasyonu** geliştirilmiştir.

# ÇALIŞMA MANTIĞI
1. Kullanıcıdan **4 haneli PIN** kodu alınır.
2. Sistem PIN’i sabit olarak Java kodu içinde tanımlanmıştır (örneğin `"1234"`).
3. Girdi, Turing makinesi formatına uygun şekilde bantta şu yapıya dönüştürülür:  
   **`#PIN#SABITPIN#`**
4. Turing makinesi, bu bant üzerinde karakter karakter ilerleyerek:
   - Kullanıcı PIN’inden bir karakteri alır (`X` ile işaretler),
   - Sabit PIN kısmına geçer, karşılık gelen karakteri bulur (`Y` ile işaretler),
   - Geri dönerek sıradaki karaktere geçer.
5. Her adımda:
   - Makinenin mevcut durumu (`q0`, `q1`, ...)  
   - Bantın güncel hali  
   - Head (ok) pozisyonu  
   konsola yazdırılır.
6. Tüm karakterler başarıyla eşleşirse:
   - **Şifre doğru (KABUL EDİLDİ)** mesajı verilir.
7. Herhangi bir eşleşme hatasında:
   - **Şifre hatalı (REDDEDİLDİ)** mesajı verilir.

# KURULUM VE ÇALIŞTIRMA
1.Java'nın kurulu olduğundan emin olun.
2.Proje dosyalarını klonlayın veya indirin.
3.Komut satırından proje klasörüne gidim.
4.Java dosyalarını derleyin.
```
javac main.java turing.java
```
5.Programı çalıştırın.
```
java main
```
# ORNEK GİRİŞ
```
Lütfen 4 haneli PIN kodunuzu girin: 1234
```

#ÖRNEK ÇIKTILAR
```
Başlangıç Bandı: 1234#1234#
[q0] (1) 2  3  4  #  1  2  3  4  # 
[q1]  X (2) 3  4  #  1  2  3  4  # 
[q2]  X  2  3  4  # (1) 2  3  4  #
[q3]  X  2  3  4 (#) Y  2  3  4  #
[q4]  X  2  3 (4) #  Y  2  3  4  #
[q4]  X  2 (3) 4  #  Y  2  3  4  #
[q4]  X (2) 3  4  #  Y  2  3  4  #
[q4] (X) 2  3  4  #  Y  2  3  4  # 
[q0]  X (2) 3  4  #  Y  2  3  4  #
[q1]  X  X (3) 4  #  Y  2  3  4  #
[q2]  X  X  3  4  # (Y) 2  3  4  #
[q2]  X  X  3  4  #  Y (2) 3  4  #
[q3]  X  X  3  4  # (Y) Y  3  4  #
[q4]  X  X  3 (4) #  Y  Y  3  4  # 
[q4]  X  X (3) 4  #  Y  Y  3  4  #
[q4]  X (X) 3  4  #  Y  Y  3  4  #
[q0]  X  X (3) 4  #  Y  Y  3  4  #
[q1]  X  X  X (4) #  Y  Y  3  4  #
[q2]  X  X  X  4  # (Y) Y  3  4  #
[q2]  X  X  X  4  #  Y (Y) 3  4  #
[q2]  X  X  X  4  #  Y  Y (3) 4  #
[q3]  X  X  X  4  #  Y (Y) Y  4  # 
[q4]  X  X  X (4) #  Y  Y  Y  4  #
[q4]  X  X (X) 4  #  Y  Y  Y  4  #
[q0]  X  X  X (4) #  Y  Y  Y  4  #
[q1]  X  X  X  X (#) Y  Y  Y  4  #
[q2]  X  X  X  X  # (Y) Y  Y  4  #
[q2]  X  X  X  X  #  Y (Y) Y  4  #
[q2]  X  X  X  X  #  Y  Y (Y) 4  #
[q4]  X  X (X) 4  #  Y  Y  Y  4  #
[q0]  X  X  X (4) #  Y  Y  Y  4  #
[q1]  X  X  X  X (#) Y  Y  Y  4  #
[q2]  X  X  X  X  # (Y) Y  Y  4  #
[q2]  X  X  X  X  #  Y (Y) Y  4  #
[q2]  X  X  X  X  #  Y  Y (Y) 4  #
[q0]  X  X  X (4) #  Y  Y  Y  4  #
[q1]  X  X  X  X (#) Y  Y  Y  4  #
[q2]  X  X  X  X  # (Y) Y  Y  4  #
[q2]  X  X  X  X  #  Y (Y) Y  4  #
[q2]  X  X  X  X  #  Y  Y (Y) 4  #
[q1]  X  X  X  X (#) Y  Y  Y  4  #
[q2]  X  X  X  X  # (Y) Y  Y  4  #
[q2]  X  X  X  X  #  Y (Y) Y  4  #
[q2]  X  X  X  X  #  Y  Y (Y) 4  #
[q2]  X  X  X  X  # (Y) Y  Y  4  #
[q2]  X  X  X  X  #  Y (Y) Y  4  #
[q2]  X  X  X  X  #  Y  Y (Y) 4  #
[q2]  X  X  X  X  #  Y (Y) Y  4  #
[q2]  X  X  X  X  #  Y  Y (Y) 4  #
[q2]  X  X  X  X  #  Y  Y (Y) 4  #
[q2]  X  X  X  X  #  Y  Y  Y (4) #
[q2]  X  X  X  X  #  Y  Y  Y (4) #
[q3]  X  X  X  X  #  Y  Y (Y) Y  #
[q4]  X  X  X (X) #  Y  Y  Y  Y  #
[q0]  X  X  X  X (#) Y  Y  Y  Y  #
[q_accept]  X  X  X  X (#) Y  Y  Y  Y  #
[q_accept] XXXX#YYYY#
Şifre doğru.
```


```
Başlangıç Bandı: 5432#1234#
[q0] (5) 4  3  2  #  1  2  3  4  # 
[q1]  X (4) 3  2  #  1  2  3  4  # 
[q2]  X  4  3  2  # (1) 2  3  4  # 
[q_reject]  X  4  3  2  # (1) 2  3  4  # 
[q_reject] X432#1234#
Şifre hatalı.
```









print(" Menampilkan MENU kelayar")
print(" 1. Identitas\n 2. Kalkulator\n 3. Perbandingan\n")

pil = int(input("Silahkan pilih menu : "))

if pil == 1:
    print("Menu Identitas")
    print(" Nama  : Ganteng\n TTL   : xx-xx-xxx\n")

elif pil == 2:
    print("Kalkulator Sederhana Python\n")
    print("1. Penjumlahan")
    print("2. Pengurangan")
    print("3. Perkalian")
    print("4. Pembagian")
    print("5. Exit")

    pil = int(input("\nMasukan Pilihan Operasi : "))

    x = int(input("Masukan Angka Pertama : "))
    y = int(input("Masukan Angka Kedua : "))

    if pil == 1:
        hasil = x+y
    elif pil == 2:
        hasil = x-y
    elif pil == 3:
        hasil = x*y
    elif pil == 4:
        hasil = x/y
    elif pil == 5:
        hasil = x%y

    print("\nHasil dari : %d" %hasil)

elif pil == 3:
    print("Menu Perbandingan\n")
    x = int(input("Masukan Angka Pertama : "))
    y = int(input("Masukan Angka Kedua : "))

    if (x > y ):
        print(x + " lebih besar dari " + y)
    elif (x < y):
        print(x + "lebih kecil dari " + y)

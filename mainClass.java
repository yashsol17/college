//sib 56 , Yash Solanke

import java.util.Scanner;

class Publication {
    String Title;
    double Price;
    int Copies;

    public int setcopies(int c) {
        this.Copies = this.Copies - c;
        return this.Copies;
    }

    public void setPrice(int c) {
        double TotalPrice = this.Price * c;
    }

    public void saleCopy(double totalPrice) {
        System.out.println("Total Publication sell: " + totalPrice);
    }
}

class Book extends Publication {
    String author;
    int Bookno;
    static int totalBooksSold = 0; // To keep track of total books sold

    Book() {
        Title = null;
        Price = 0.0;
        Copies = 0;
        author = null;
    }

    Book(int index, String T, String a, double p, int c) {
        Bookno = index;
        Title = T;
        Price = p;
        author = a;
        Copies = c;
    }

    public double orderCopies(Book[] b) {
        double totalPrice = 0.0;
        int flag = 0, ch;
        Scanner scr = new Scanner(System.in);

        do {
            System.out.println("Books available with us:");
            // Add column headings
            System.out.println("SrNo\tTitle\tAuthor\t\tPrice\tCopies");
            for (int i = 0; i < 3; i++) {
                System.out.println(b[i].Bookno + "\t" + b[i].Title + "\t" + b[i].author + "\t" + b[i].Price + "\t" + b[i].Copies);
            }

            System.out.println("Enter the Book Number You want to Order");
            int Bno = scr.nextInt();
            int qty;
            for (int i = 0; i < 3; i++) {
                if (b[i].Bookno == Bno) {
                    System.out.println("Enter no of copies You want to Order");
                    qty = scr.nextInt();
                    if (b[i].Copies >= qty) {
                        System.out.println("Copies Ordered Successfully");
                        totalPrice = totalPrice + (b[i].Price * qty);
                        totalBooksSold += qty;
                        System.out.println("Total amount for " + b[i].Title + " is :" + totalPrice);
                        System.out.println("No of Copies of " + b[i].Title + " left are " + b[i].setcopies(qty));
                        flag = 1;
                        break;
                    } else {
                        System.out.println("Sorry, Not sufficient Copies");
                    }
                } else {
                    flag = 0;
                }
            }
            if (flag == 0) {
                System.out.println("Book not Found");
            }
            System.out.println("Do you want to order more books? \n 1: Yes    2: No ");
            ch = scr.nextInt();

        } while (ch == 1);
        return totalPrice;
    }

    public void saleCopy(double totalPrice) {
        System.out.println("Total Books sold: " + totalBooksSold);
        System.out.println("Total Books sell amount: " + totalPrice);
    }
}

class Magazine extends Publication {
    int Mno;
    int currentissued = 0;
    static int totalMagazinesSold = 0;

    Magazine() {
        Title = null;
        Price = 0.0;
        Copies = 0;
    }

    Magazine(int index, String T, double p, int c) {
        Mno = index;
        Title = T;
        Price = p;
        Copies = c;
    }

    public double orderQty(Magazine[] m) {
        double totalPrice = 0.0;
        int flag = 0, ch;
        Scanner scr = new Scanner(System.in);

        do {
            System.out.println("Magazines available with us:");
            // Add column headings
            System.out.println("SrNo\tTitle\tPrice\tCopies");
            for (int i = 0; i < 2; i++) {
                System.out.println(m[i].Mno + "\t" + m[i].Title + "\t" + m[i].Price + "\t" + m[i].Copies);
            }

            System.out.println("Enter the Magazine no You want to Order");
            int index1 = scr.nextInt();
            int qty;
            for (int i = 0; i < 2; i++) {
                if (m[i].Mno == index1) {
                    System.out.println("Enter no of copies You want to Order");
                    qty = scr.nextInt();
                    if (m[i].Copies >= qty) {
                        System.out.println("Copies Ordered Successfully");
                        currentissued = qty;
                        totalMagazinesSold += qty; 
                        System.out.println("Copies currently issued are : " + currentissued);
                        System.out.println("No of Copies of " + m[i].Title + " left are " + m[i].setcopies(qty));
                        totalPrice = totalPrice + (m[i].Price * qty);
                        flag = 1;
                        break;
                    } else {
                        System.out.println("Sorry, Not sufficient Copies");
                    }
                } else {
                    flag = 0;
                }
            }
            if (flag == 0) {
                System.out.println("Magazine not Found");
            }
            System.out.println("Do you want to order more Magazines? \n 1: Yes    2: No ");
            ch = scr.nextInt();
        } while (ch == 1);
        return totalPrice;
    }

    public void saleCopy(double totalPrice) {
        System.out.println("Total Magazines sold: " + totalMagazinesSold);
        System.out.println("Total Magazine sell amount: " + totalPrice);
    }
}

public class mainClass {
    public static void main(String[] args) {
        int qty = 0, i, ch, ch1;
        double price, mp = 0, p = 0;

        Book[] Booklist = new Book[3];
        Booklist[0] = new Book(1, "Java", "Herbert Schildt", 900, 10);
        Booklist[1] = new Book(2, "DBMS", "Jason Price", 4000, 10);
        Booklist[2] = new Book(3, "Cloud", "B. Spendolini", 4000, 10);

        Magazine[] m1 = new Magazine[2];
        m1[0] = new Magazine(1, "Vogue", 300, 10);
        m1[1] = new Magazine(2, "People", 400, 10);

        System.out.println("Welcome to the store");
        do {
            System.out.println("Enter the correct choice to order \n 1: Book        2: Magazine");
            Book obj1 = new Book();

            Magazine m = new Magazine();
            Scanner scr = new Scanner(System.in);
            ch = scr.nextInt();
            if (ch == 1) {
                p = obj1.orderCopies(Booklist);
                obj1.saleCopy(p);
            } else {
                mp = m.orderQty(m1);
                m.saleCopy(mp);
            }
            System.out.println("\nDo you want to order something more? \n 1: Yes    2: No");
            ch1 = scr.nextInt();
        } while (ch1 == 1);
        Publication obj3 = new Publication();
        obj3.saleCopy((p + mp));

        System.out.println("Total Books Sold: " + Book.totalBooksSold);
        System.out.println("Total Magazines Sold: " + Magazine.totalMagazinesSold);
        System.out.println("Total Publication sell amount: " + (p + mp));
    }
}

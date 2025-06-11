import java.util.*;

public class Main {

    static class Book {
        private String title;
        private String author;
        private int availableCopies;
        private int totalCopies;

        public Book(String title, String author, int availableCopies, int totalCopies) {
            this.title = title;
            this.author = author;
            this.availableCopies = availableCopies;
            this.totalCopies = totalCopies;
        }

        public String getTitle() {
            return title;
        }

        public boolean isAvailable() {
            return availableCopies > 0;
        }

        public void borrowBook() {
            if (availableCopies > 0) {
                availableCopies--;
            }
        }

        public void returnBook() {
            if (availableCopies < totalCopies) {
                availableCopies++;
            }
        }

        public void bookSpecification() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Available Copies: " + availableCopies);
            System.out.println("Total Copies: " + totalCopies);
        }
    }

    static class Member {
        private String memberName;
        private String memberId;
        private List<Book> booksBorrowed;

        public Member(String memberName, String memberId) {
            this.memberName = memberName;
            this.memberId = memberId;
            this.booksBorrowed = new ArrayList<>();
        }

        public String getMemberName() {
            return memberName;
        }

        public String getMemberId() {
            return memberId;
        }

        public int borrowBook(Book book) {
            if (book.isAvailable()) {
                booksBorrowed.add(book);
                book.borrowBook();
                return 1;
            }
            return 0;
        }

        public void returnBook(Book book) {
            if (booksBorrowed.remove(book)) {
                System.out.println(book.getTitle() + " returned successfully");
                book.returnBook();
            } else {
                System.out.println(book.getTitle() + " wasn't borrowed");
            }
        }
    }

    static class Library {
        private List<Book> booksAvailable;
        private List<Member> members;

        public Library() {
            this.booksAvailable = new ArrayList<>();
            this.members = new ArrayList<>();
        }

        public void addBook(Book book) {
            booksAvailable.add(book);
            System.out.println(book.getTitle() + " added successfully.");
        }

        public void addMember(Member member) {
            members.add(member);
            System.out.println(member.getMemberName() + " added successfully.");
        }

        public Book findBook(String name) {
            for (Book book : booksAvailable) {
                if (book.getTitle().equalsIgnoreCase(name)) {
                    return book;
                }
            }
            System.out.println(name + " isn't available in the library");
            return null;
        }

        public Member findMember(String memberId) {
            for (Member member : members) {
                if (member.getMemberId().equals(memberId)) {
                    return member;
                }
            }
            System.out.println(memberId + " is not registered.");
            return null;
        }

        public void borrowBook(Member member, Book book) {
            Member tempMember = findMember(member.getMemberId());
            Book tempBook = findBook(book.getTitle());

            if (tempMember == null || tempBook == null) {
                System.out.println("Either member is not registered or book isn't available.");
                return;
            }

            int result = tempMember.borrowBook(tempBook);
            if (result == 1) {
                System.out.println(book.getTitle() + " borrowed successfully by " + member.getMemberName());
            } else {
                System.out.println(book.getTitle() + " is not available.");
            }
        }

        public void returnBook(Member member, Book book) {
            Member tempMember = findMember(member.getMemberId());
            Book tempBook = findBook(book.getTitle());

            if (tempMember == null || tempBook == null) {
                System.out.println("Either member is not registered or book isn't available.");
                return;
            }

            tempMember.returnBook(tempBook);
        }
    }

    public static void main(String[] args) {
        Library isbmLibrary = new Library();

        Member krishna = new Member("Krishnakant Tiwari", "BE68");
        isbmLibrary.addMember(krishna);

        Book atomicHabits = new Book("Atomic Habits", "James Clear", 10, 10);
        isbmLibrary.addBook(atomicHabits);

        atomicHabits.bookSpecification();

        for (int i = 1; i <= 11; i++) {
            System.out.println("\nBorrow attempt #" + i);
            isbmLibrary.borrowBook(krishna, atomicHabits);
        }
    }
}

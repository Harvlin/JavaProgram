import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private boolean isAvailable;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        isAvailable = false;
    }

    public void cancelReservation() {
        isAvailable = true;
    }
}

class RoomReservationSystem {
    private ArrayList<Room> rooms;

    public RoomReservationSystem(int numberOfRooms) {
        rooms = new ArrayList<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public void displayRooms(boolean showAvailableOnly) {
        for (Room room : rooms) {
            if (!showAvailableOnly || room.isAvailable()) {
                System.out.println("Room " + room.getRoomNumber() + (room.isAvailable() ? " - Available" : " - Reserved"));
            }
        }
    }

    public void reserveRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.reserve();
                System.out.println("Room " + roomNumber + " reserved successfully.");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not available or does not exist.");
    }

    public void cancelReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isAvailable()) {
                room.cancelReservation();
                System.out.println("Reservation for Room " + roomNumber + " canceled.");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not reserved or does not exist.");
    }
}

public class roomReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rooms: ");
        int numberOfRooms = scanner.nextInt();
        RoomReservationSystem reservationSystem = new RoomReservationSystem(numberOfRooms);

        while (true) {
            System.out.println("\nRoom Reservation Menu:");
            System.out.println("1. Display Rooms");
            System.out.println("2. Reserve a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Displaying All Rooms:");
                    reservationSystem.displayRooms(false);
                    break;
                case 2:
                    System.out.print("Enter room number to reserve: ");
                    int reserveRoomNumber = scanner.nextInt();
                    reservationSystem.reserveRoom(reserveRoomNumber);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel reservation: ");
                    int cancelRoomNumber = scanner.nextInt();
                    reservationSystem.cancelReservation(cancelRoomNumber);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

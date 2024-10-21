import java.util.ArrayList;
import java.util.List;



public class ParkingLot {
    String ParkingID;
    List<List<Slot>> slots;

    public ParkingLot(String ParkingID, String vehicle, int floorNumber, int slotNumberOnParking) {
        this.ParkingID = ParkingID;


        slots = new ArrayList<>();
        for (int i = 0; i < floorNumber; i++) {
            slots.add(new ArrayList<>());
            List<Slot> floorSlots = slots.get(i);
            floorSlots.add(new Slot("truck"));
            floorSlots.add(new Slot("bycycle"));
            floorSlots.add(new Slot("bike"));

            for (int j = 0; j < slotNumberOnParking; j++) {
                slots.get(i).add(new Slot("car"));
            }

        }
    }

    public ParkingLot() {
    }

    String parkSlots(String type, String regNumber) {
        Vehicle vehicle = new Vehicle();
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.type == type && slot.vehicle == null) {
                    slot.vehicle = vehicle;
                    slot.ticketID = generateTicketID(i + 1, j + 1);
                    return slot.ticketID;
                }
            }
        }

        System.out.println("NOT avaliable slot for this type ");
        return null;
        // или лучше сделать эксепшн?
    }

    private String generateTicketID(int floor, int slotNumber) {
        return ParkingID + " " + floor + " " + slotNumber;
    }

    public void unParkSlot(String ticketID) throws IllegalStateException {
        String[] extract = ticketID.split(" ");
        int floor_idx = Integer.parseInt(extract[1]) - 1;
        int slot_idx = Integer.parseInt(extract[2]) - 1;
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                if (i == floor_idx && j == slot_idx) {
                    Slot slot = slots.get(i).get(j);
                    slot.vehicle = null;
                    slot.ticketID = null;

                }
                System.out.println("Uparked vehicle");
            }
        }
    }

    int getFreeOpenSlots(String type) {
        int count = 0;
        for (List<Slot> floor : slots) {
            for (Slot slot : floor) {
                if (slot.vehicle == null && slot.type.equals(type)) count++;
            }
        }
        return count;
    }

    //отображаем свободные места
    void watchOpenSlots(String type) {
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.vehicle == null && slot.type.equals(type))
                    System.out.println("Floor" + (i + 1) + "Floor" + (j + 1));
            }
        }
    }

    //отображаем занятые места, точно не знаю, но судя по всему для тестирования приложения потом
    //во многих код-ревью так пишут
    void watchOccupySlots(String type) {
        for (int i = 0; i < slots.size(); i++) {
            for (int j = 0; j < slots.get(i).size(); j++) {
                Slot slot = slots.get(i).get(j);
                if (slot.vehicle != null && slot.type.equals(type))
                    System.out.println("Floor" + (i + 1) + "Floor" + (j + 1));
            }
        }
    }
}




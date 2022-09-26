package c1.CollectMethods;


import java.util.*;

// Collections method
//copy
//shuffle
//min
//max
//sorted
 class Theatre {
    private final String theatreName;
    public List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

   boolean reserveSeat(String seatNumber) {
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    // for testing
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }


     class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }










        public static void main(String[] args) {

            Theatre theatre = new Theatre("Olympian", 8, 12);
            List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
            printList(seatCopy);

            seatCopy.get(1).reserve();
            if (theatre.reserveSeat("A02")) {
                System.out.println("Please pay for A02");
            } else {
                System.out.println("Seat already reserved");
            }

            Collections.shuffle(seatCopy);
            System.out.println("Printing seatCopy");
            printList(seatCopy);
            System.out.println("Printing theatre.seat");
            printList(theatre.seats);

            Theatre.Seat minSeat = Collections.min(seatCopy);
            Theatre.Seat maxSeat = Collections.max(seatCopy);
            System.out.println("Min seat number is " + minSeat.getSeatNumber());
            System.out.println("Max seat number is " + maxSeat.getSeatNumber());

            sortList(seatCopy);
            System.out.println("Printing sorted seatCopy");
            printList(seatCopy);


            List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
            System.out.println(newList.size());
            Collections.copy(newList, theatre.seats);
        }


        public static void printList(List<Theatre.Seat> list) {
            for (Theatre.Seat seat : list) {
                System.out.print(" " + seat.getSeatNumber());
            }
            System.out.println();
            System.out.println("======================================================================");
        }

        public static void sortList(List<? extends Theatre.Seat> list) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).compareTo(list.get(j)) > 0) {
                        Collections.swap(list, i, j);
                    }
                }
            }
        }
    }

///output
//A01 A02 A03 A04 A05 A06 A07 A08 A09 A10 A11 A12 B01 B02 B03 B04 B05 B06 B07 B08 B09 B10 B11 B12 C01 C02 C03 C04 C05 C06 C07 C08 C09 C10 C11 C12 D01 D02 D03 D04 D05 D06 D07 D08 D09 D10 D11 D12 E01 E02 E03 E04 E05 E06 E07 E08 E09 E10 E11 E12 F01 F02 F03 F04 F05 F06 F07 F08 F09 F10 F11 F12 G01 G02 G03 G04 G05 G06 G07 G08 G09 G10 G11 G12 H01 H02 H03 H04 H05 H06 H07 H08 H09 H10 H11 H12
//======================================================================
//        Seat A02 reserved
//        .......Seat already reserved
//        Printing seatCopy
//        A06 G06 E08 C11 A02 B05 D03 D11 B06 E05 F01 E12 H09 C08 G01 H03 D01 G12 F10 C10 C12 C05 A11 G05 G03 B08 D09 C04 F05 A07 F03 E06 A08 B10 G09 A03 A04 A09 F11 D07 H02 B01 G11 C09 C01 H08 G04 C06 F09 C02 E03 H05 E01 F04 E07 A01 G07 C07 E09 B09 D06 H07 F06 H11 E11 F02 H12 B02 H04 B03 B12 F07 E02 D05 H06 B11 D10 B07 B04 C03 D04 H10 A12 F12 F08 D12 A05 D02 E04 A10 E10 D08 G08 G10 G02 H01
//        ======================================================================
//        Printing theatre.seat
//        A01 A02 A03 A04 A05 A06 A07 A08 A09 A10 A11 A12 B01 B02 B03 B04 B05 B06 B07 B08 B09 B10 B11 B12 C01 C02 C03 C04 C05 C06 C07 C08 C09 C10 C11 C12 D01 D02 D03 D04 D05 D06 D07 D08 D09 D10 D11 D12 E01 E02 E03 E04 E05 E06 E07 E08 E09 E10 E11 E12 F01 F02 F03 F04 F05 F06 F07 F08 F09 F10 F11 F12 G01 G02 G03 G04 G05 G06 G07 G08 G09 G10 G11 G12 H01 H02 H03 H04 H05 H06 H07 H08 H09 H10 H11 H12
//        ======================================================================
//        Min seat number is A01
//        Max seat number is H12
//        Printing sorted seatCopy
//        A01 A02 A03 A04 A05 A06 A07 A08 A09 A10 A11 A12 B01 B02 B03 B04 B05 B06 B07 B08 B09 B10 B11 B12 C01 C02 C03 C04 C05 C06 C07 C08 C09 C10 C11 C12 D01 D02 D03 D04 D05 D06 D07 D08 D09 D10 D11 D12 E01 E02 E03 E04 E05 E06 E07 E08 E09 E10 E11 E12 F01 F02 F03 F04 F05 F06 F07 F08 F09 F10 F11 F12 G01 G02 G03 G04 G05 G06 G07 G08 G09 G10 G11 G12 H01 H02 H03 H04 H05 H06 H07 H08 H09 H10 H11 H12
//        ======================================================================



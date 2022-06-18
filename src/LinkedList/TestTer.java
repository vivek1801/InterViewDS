package LinkedList;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestTer {

  public static void main(String[] args) {
    //Comparator to sort based on start date
    Comparator<UserIdDateRange> userIdDateRangeComparator = Comparator
      .comparing(UserIdDateRange::getStartDate);
    //Comparator to sort based on date range
    Comparator<UserIdDateRange> dateRangeComparator = Comparator
      .comparing(tti -> DAYS.between(tti.getStartDate(), tti.getEndDate()));
    Comparator<UserIdDateRange> newComparator=dateRangeComparator.thenComparing(userIdDateRangeComparator);
    List<UserIdDateRange> userIdDateRangeList=createTTI1();
    //Sorted TTI
    List<UserIdDateRange> list= userIdDateRangeList.stream()
      .sorted(newComparator).collect(Collectors.toList());
    list.forEach(user-> System.out.println(user.getUserId()));
  }

  private static void createTTI(int userId, int startDate, int endDate, List<UserIdDateRange> ttiList) {
    UserIdDateRange tti = new UserIdDateRange();
    tti.setUserId(String.valueOf(userId));
    tti.setStartDate(LocalDate.now().plusDays(startDate));
    tti.setEndDate(LocalDate.now().plusDays(endDate));
    ttiList.add(tti);
  }

  private static List<UserIdDateRange> createTTI1() {
    List<UserIdDateRange> ttiList = new ArrayList<>();
    createTTI(1, 0, 4, ttiList);
    createTTI(2, 1, 2, ttiList);
    createTTI(3, 0, 2, ttiList);
    createTTI(3, 3, 5, ttiList);
    createTTI(4, 0, 7, ttiList);
    createTTI(5, 0, 1, ttiList);
    createTTI(6, 0, 1, ttiList);
    createTTI(7, 1, 3, ttiList);
    createTTI(8, 0, 2, ttiList);
    createTTI(9, 0, 2, ttiList);
    createTTI(9, 4, 6, ttiList);
    return ttiList;
  }
}

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {

  static DateRange createDateRange(LocalDate start, LocalDate end) {
    DateRange dateRange = new DateRange(start, end);
    return dateRange;
  }

  public static void main(String[] args) {
    List<LocalDate> localDateListDB = new ArrayList<>();
    localDateListDB.add(LocalDate.now().plusDays(0));
    localDateListDB.add(LocalDate.now().plusDays(1));
    localDateListDB.add(LocalDate.now().plusDays(2));


    final LocalDate startDate = LocalDate.now();
    final LocalDate endDate = startDate.plusDays(10);
    List<LocalDate> localDateListContinuous=
      LongStream.rangeClosed(0, DAYS.between(startDate, endDate)).mapToObj(startDate::plusDays).collect(
        Collectors.toList());
    localDateListContinuous.removeAll(localDateListDB);

    List<DateRange> dateRanges = new ArrayList<>();
    LocalDate prev = localDateListContinuous.get(0);
    LocalDate start = prev;
    for (int i = 1; i < localDateListContinuous.size(); i++) {
      LocalDate next = localDateListContinuous.get(i);
      if (!prev.plusDays(1).equals(next)) {
        DateRange dateRange = createDateRange( start, prev);
        dateRanges.add(dateRange);
        start = next;
      }
      prev = next;
      if (localDateListContinuous.size() == i + 1) {
        DateRange dateRange = createDateRange(start, prev);
        dateRanges.add(dateRange);
      }
    }
    for (DateRange lo : dateRanges) {
      System.out.println(lo.getStartDate()+"___"+lo.getEnddate());
    }
  }
}

class DateRange {
  public DateRange(LocalDate startDate, LocalDate enddate) {
    this.startDate = startDate;
    this.enddate = enddate;
  }

  LocalDate startDate;
  LocalDate enddate;

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEnddate() {
    return enddate;
  }

  public void setEnddate(LocalDate enddate) {
    this.enddate = enddate;
  }
}
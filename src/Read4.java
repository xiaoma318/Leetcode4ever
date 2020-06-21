public class Read4 {

  /**
   * The API: int read4(char *buf) reads 4 characters at a time from a file. The return value is the
   * actual number of characters read. For example, it returns 3 if there is only 3 characters left
   * in the file. By using the read4 API, implement the function int read(char *buf, int n) that
   * reads n characters from the file. Note: The read function will only be called once for each
   * test case.
   */
  public int read(char[] buf, int n) {
    int total = 0;
    char[] buffer = new char[4];
    boolean eof = false;
    while (total < n && !eof) {
      int count = read4(buffer);
      eof = count < 4;
      count = Math.min(count, n - total);

      for (int i = 0; i < count; i++) {
        buf[total++] = buffer[i];
      }
    }

    return total;
  }

  private char[] buffer = new char[4];
  private int offset = 0;
  private int count = 0;

  public int read2(char[] buf, int n) {
    int total = 0;
    boolean eof = false;
    while (!eof && total < n) {
      if (count == offset) {
        offset = 0;
        count = read4(buffer);
        eof = count < 4;
      }
      while (offset < count && total < n) {
        buf[total++] = buffer[offset++];
      }

    }
    return total;
  }

  int read4(char[] buf) {
    return 1;
  }
}

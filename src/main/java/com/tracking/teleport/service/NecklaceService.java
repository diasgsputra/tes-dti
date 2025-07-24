package com.tracking.teleport.service;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class NecklaceService{

  public int getMaxBeadsCollected(int n, String necklace) {
    String doubled = necklace + necklace;
    int max = 0;

    for (int i = 0; i < n; i++) {
      int leftCount = countBeads(doubled, i - 1 + n, -1, n);
      int rightCount = countBeads(doubled, i, 1, n);

      int total = leftCount + rightCount;
      if (total > n) total = n;

      max = Math.max(max, total);
    }

    return max;
  }

  private int countBeads(String s, int start, int direction, int n) {
    int count = 0;
    char color = 'w';

    for (int i = 0; i < n; i++) {
      int idx = (start + direction * i + s.length()) % s.length();
      char c = s.charAt(idx);

      if (c != 'w') {
        if (color == 'w') color = c;
        else if (c != color) break;
      }

      count++;
    }

    return count;
  }


}

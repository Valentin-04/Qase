package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestCase {
    String title;
    String status;
    String description;
    String suite;
    String severity;
    String priority;
    String type;
    String milestone;
    String behavior;
    String automationStatus;
    String preConditions;
    String postConditions;
    String action;
    String inputData;
    String expectedResult;
}

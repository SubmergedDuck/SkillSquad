package use_case.get_most_recent_event;

/**
 * Output boundary for the get recent event use case.
 */
public interface RecentEventOutputBoundary {
    void prepareView(RecentEventOutputData outputData);
}

package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsSuiteTest {

    @Mock
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        forumStatistics = new ForumStatistics();
    }

    private List<String> generateListOfUsers(int n) {
        List<String> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            users.add("User" + i);
        }
        return users;
    }

    @Test
    public void calculateAdvStatisticsWhenZeroPostsCaseTest() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(50);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, forumStatistics.getUsersCount());
        assertEquals(0, forumStatistics.getPostsCount());
        assertEquals(50, forumStatistics.getCommentsCount());
        assertEquals(0, forumStatistics.getAvgPostsPerUser());
        assertEquals(5, forumStatistics.getAvgCommentsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    public void calculateAdvStatisticsWhen1000PostsCaseTest() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(20));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(20, forumStatistics.getUsersCount());
        assertEquals(1000, forumStatistics.getPostsCount());
        assertEquals(500, forumStatistics.getCommentsCount());
        assertEquals(50, forumStatistics.getAvgPostsPerUser());
        assertEquals(25, forumStatistics.getAvgCommentsPerUser());
        assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    public void calculateAdvStatisticsWhenZeroCommentsCaseTest() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(15));
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(15, forumStatistics.getUsersCount());
        assertEquals(10, forumStatistics.getPostsCount());
        assertEquals(0, forumStatistics.getCommentsCount());
        assertEquals(0.66, forumStatistics.getAvgPostsPerUser(), 0.01);
        assertEquals(0, forumStatistics.getAvgCommentsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    public void calculateAdvStatisticsWhenCommentsLessThenPostsCaseTest() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, forumStatistics.getUsersCount());
        assertEquals(100, forumStatistics.getPostsCount());
        assertEquals(50, forumStatistics.getCommentsCount());
        assertEquals(10, forumStatistics.getAvgPostsPerUser());
        assertEquals(5, forumStatistics.getAvgCommentsPerUser());
        assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    public void calculateAdvStatisticsWhenCommentsMoreThenPostsCaseTest() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, forumStatistics.getUsersCount());
        assertEquals(50, forumStatistics.getPostsCount());
        assertEquals(100, forumStatistics.getCommentsCount());
        assertEquals(5, forumStatistics.getAvgPostsPerUser());
        assertEquals(10, forumStatistics.getAvgCommentsPerUser());
        assertEquals(2, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    public void calculateAdvStatisticsZeroUsersCaseTest() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(0));
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getUsersCount());
        assertEquals(50, forumStatistics.getPostsCount());
        assertEquals(100, forumStatistics.getCommentsCount());
        assertEquals(0, forumStatistics.getAvgPostsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerUser());
        assertEquals(2, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    public void calculateAdvStatistics100UsersCaseTest() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(100));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(300);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getUsersCount());
        assertEquals(100, forumStatistics.getPostsCount());
        assertEquals(300, forumStatistics.getCommentsCount());
        assertEquals(1, forumStatistics.getAvgPostsPerUser());
        assertEquals(3, forumStatistics.getAvgCommentsPerUser());
        assertEquals(3, forumStatistics.getAvgCommentsPerPost());
    }
}



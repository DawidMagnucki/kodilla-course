package com.kodilla.hibernate.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@NamedQueries({
        @NamedQuery(
                name = "Task.retrieveLongTasks",
                query = "FROM Task WHERE duration > 10"
        ),
        @NamedQuery(
                name = "Task.retrieveShortTasks",
                query = "FROM Task WHERE duration <= 10"
        ),
        @NamedQuery(
                name ="Task.retrieveTasksWithDurationLongerThan",
                query = "FROM Task WHERE duration > :DURATION"
        )
})
@NamedNativeQuery(
        name = "Task.retrieveTasksWithEnoughTime",
        query = "SELECT * FROM TASKS" +
                " WHERE DATEDIFF(DATE_ADD(CREATED, INTERVAL DURATION DAY), NOW()) > 5",
        resultClass = Task.class
)
@Entity                     // encja = tabela - daje znac obiekty danej klasy mają być przechowywane w bazie danych
@Table(name = "TASKS")      // Hibernate automatycznie stworzy tabele o nazwie takiej samej jak klasa, wiec jezeli chcemy zmienic nazwe tabeli musimy uzyc adnotacji @Table(name="...")
public final class Task {
                            //*****UWAGA***** @Entity zmienia zarowno nazwe *klasy* jak i nazwe tabeli. @Table zmienia tylko nazwe tabeli
                            //Dodatkowo: Adnotacja @Access nad klasą @Access(AccessType.FIELD) – dla dostępu przez pola klasy, @Access(AccessType.PROPERTY) – dla dostępu przy pomocy akcesorów (gettery i settery).
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private TaskList taskList;


    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id                                                     //primary-key
    @GeneratedValue                                         //auto-increment
    @NotNull                                                //not-null
    @Column(name = "ID", unique = true)                     //unique - wartosc nie moze sie powtarzac.
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")                           //Dodatkowo: Adnotacja @Transient - kiedy chcemy cos ominac, zeby Hibernate nie bral tego pod uwage.
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASKS_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn(name = "TASKlIST_ID")
    public TaskList getTaskList() {
        return taskList;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}

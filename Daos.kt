import androidx.room.*
import com.example.nahockeyapp.data.Event
import com.example.nahockeyapp.data.Player
import com.example.nahockeyapp.data.Team

@Dao
interface TeamDao {
    @Query("SELECT * FROM teams")
    suspend fun getAllTeams(): List<Team>

    @Query("SELECT * FROM teams WHERE id = :id")
    suspend fun getTeamById(id: String): Team?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: Team)

    @Update
    suspend fun updateTeam(team: Team)

    @Delete
    suspend fun deleteTeam(team: Team)
}
@Dao
interface PlayerDao {
    @Query("SELECT * FROM players")
    suspend fun getAllPlayers(): List<Player>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: Player)

    // Add other necessary queries
}

@Dao
interface EventDao {
    @Query("SELECT * FROM events")
    suspend fun getAllEvents(): List<Event>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: Event)
    // Add other necessary queries

}
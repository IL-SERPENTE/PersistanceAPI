/*
===============================================================
   _____                       ______
  / ___/____ _____ ___  ____ _/ ____/___ _____ ___  ___  _____
  \__ \/ __ `/ __ `__ \/ __ `/ / __/ __ `/ __ `__ \/ _ \/ ___/
 ___/ / /_/ / / / / / / /_/ / /_/ / /_/ / / / / / /  __(__  )
/____/\__,_/_/ /_/ /_/\__,_/\____/\__,_/_/ /_/ /_/\___/____/

===============================================================
  Persistance API
  Copyright (c) for SamaGames, all right reserved
  By MisterSatch, January 2016
===============================================================
*/

package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.statistics.PlayerStatisticsBean;
import net.samagames.persistanceapi.beans.statistics.*;
import net.samagames.persistanceapi.datamanager.aggregationmanager.statistics.*;

import javax.sql.DataSource;

public class StatisticsManager
{
    // Defines
    public DimensionsStatisticsManager dimensionsStatsManager;
    public JukeBoxStatisticsManager jukeBoxStatsManager;
    public QuakeStatisticsManager quakeStatsManager;
    public UHCOriginalStatisticsManager uhcOriginalStatsManager;
    public UHCRunStatisticsManager uhcRunStatsManager;
    public DoubleRunnerStatisticsManager doubleRunnerStatsManager;
    public UHCRandomStatisticsManager uhcRandomStatsManager;
    public RandomRunStatisticsManager randomRunStatsManager;
    public UltraFlagKeeperStatisticsManager ultraFlagKeeperStatsManager;
    public UppervoidStatisticsManager uppervoidStatsManager;
    public ChunkWarsStatisticsManager chunkWarsStatisticsManager;
    public NetworkStatisticsManager networkStatisticsManager;

    // Constructor
    public StatisticsManager()
    {
        this.dimensionsStatsManager = new DimensionsStatisticsManager();
        this.jukeBoxStatsManager = new JukeBoxStatisticsManager();
        this.quakeStatsManager = new QuakeStatisticsManager();
        this.uhcOriginalStatsManager = new UHCOriginalStatisticsManager();
        this.uhcRunStatsManager = new UHCRunStatisticsManager();
        this.doubleRunnerStatsManager = new DoubleRunnerStatisticsManager();
        this.uhcRandomStatsManager = new UHCRandomStatisticsManager();
        this.randomRunStatsManager = new RandomRunStatisticsManager();
        this.ultraFlagKeeperStatsManager = new UltraFlagKeeperStatisticsManager();
        this.uppervoidStatsManager = new UppervoidStatisticsManager();
        this.chunkWarsStatisticsManager = new ChunkWarsStatisticsManager();
        this.networkStatisticsManager = new NetworkStatisticsManager();
    }

    // Get all player statistics
    public PlayerStatisticsBean getAllPlayerStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        // Declared bean
        DimensionsStatisticsBean dimensionsStats;
        JukeBoxStatisticsBean jukeBoxStats;
        QuakeStatisticsBean quakeStats;
        UHCOriginalStatisticsBean uhcOriginalStats;
        UHCRunStatisticsBean uhcRunStats;
        DoubleRunnerStatisticsBean doubleRunnerStats;
        UHCRandomStatisticsBean uhcRandomStats;
        RandomRunStatisticsBean randomRunStats;
        UltraFlagKeeperStatisticsBean ultraFlagKeeperStats;
        UppervoidStatisticsBean upperVoidStats;
        ChunkWarsStatisticsBean chunkWarsStats;

        // Get the different statistics bean
        try
        {
            dimensionsStats = this.dimensionsStatsManager.getDimensionsStatistics(player, dataSource);
            jukeBoxStats = this.jukeBoxStatsManager.getJukeBoxStatistics(player, dataSource);
            quakeStats = this.quakeStatsManager.getQuakeStatistics(player, dataSource);
            uhcOriginalStats = this.uhcOriginalStatsManager.getUHCOriginalStatistics(player, dataSource);
            uhcRunStats = this.uhcRunStatsManager.getUHCRunStatistics(player, dataSource);
            doubleRunnerStats = this.doubleRunnerStatsManager.getDoubleRunnerStatistics(player, dataSource);
            uhcRandomStats = this.uhcRandomStatsManager.getUHCRandomStatistics(player, dataSource);
            randomRunStats = this.randomRunStatsManager.getRandomRunStatistics(player, dataSource);
            ultraFlagKeeperStats = this.ultraFlagKeeperStatsManager.getUltraFlagKeeperStatistics(player, dataSource);
            upperVoidStats = this.uppervoidStatsManager.getUppervoidStatistics(player, dataSource);
            chunkWarsStats = this.chunkWarsStatisticsManager.getChunkWarsStatistics(player, dataSource);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }

        // Create the aggregation of different statistics bean
        PlayerStatisticsBean playerStatisticsBean = new PlayerStatisticsBean(dimensionsStats, jukeBoxStats, quakeStats, uhcOriginalStats, uhcRunStats, doubleRunnerStats, uhcRandomStats, randomRunStats, ultraFlagKeeperStats, upperVoidStats, chunkWarsStats);
        return playerStatisticsBean;
    }

    // Update all player statistics
    public void updateAllPlayerStatistics(PlayerBean player, PlayerStatisticsBean datas, DataSource dataSource) throws Exception
    {
        // Update the different statistics bean
        try
        {
            this.dimensionsStatsManager.updateDimensionsStatistics(player, datas.getDimensionsStats(),dataSource);
            this.jukeBoxStatsManager.updateJukeBoxStatistics(player, datas.getJukeBoxStats(), dataSource);
            this.quakeStatsManager.updateQuakeStatistics(player, datas.getQuakeStats(), dataSource);
            this.uhcOriginalStatsManager.updateUHCOriginalStatistics(player, datas.getUHCOriginalStats(), dataSource);
            this.uhcRunStatsManager.updateUHCRunStatistics(player, datas.getUHCRunStats(), dataSource);
            this.doubleRunnerStatsManager.updateDoubleRunnerStatistics(player, datas.getDoubleRunnerStats(), dataSource);
            this.uhcRandomStatsManager.updateUHCRandomStatistics(player, datas.getUHCRandomStats(), dataSource);
            this.randomRunStatsManager.updateRandomRunStatistics(player, datas.getRandomRunStats(), dataSource);
            this.ultraFlagKeeperStatsManager.updateUltraFlagKeeperStatistics(player, datas.getUltraFlagKeeperStats(), dataSource);
            this.uppervoidStatsManager.updateUppervoidStatistics(player, datas.getUppervoidStats(), dataSource);
            this.chunkWarsStatisticsManager.updateChunkWarsStatistics(player, datas.getChunkWarsStats(), dataSource);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }

    }

}

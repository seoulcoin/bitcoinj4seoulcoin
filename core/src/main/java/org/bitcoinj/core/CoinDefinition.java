package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {

    public static final boolean useFairPay = true;

    public static final String coinName = "bitcoinj";//"FairPay";
    public static final String coinTicker = "COIN";
    public static final String coinURIScheme = "fairpay";
    public static final String cryptsyMarketId = "26";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "[56]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[KL]";
    public static final String PATTERN_PRIVATE_KEY_START_TESTNET = "9";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED_TESTNET = "c";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "https://info.fairpay.biz/coin/";
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address.dws?";
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx.dws?";
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block.dws?";
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "FkknEYnex1MeZyPRnEebFK5ZBHHsFZbvaf";  //HashEngineering donation GRS address

    public static final String UNSPENT_API_URL = "https://info.fairpay.biz/coin/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;

    public static final int TARGET_TIMESPAN = (int)(2 * 24 * 60 * 60);  // 1 day per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 60);  // 60 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //2880 blocks

    public static final int getIntervalCheckpoints() {
            return 2016;    //1080

    }
    public static int spendableCoinbaseDepth = 100; //main.h: static const int CINBASE_MATURITY
    public static final long MAX_COINS = (10000000000L);                 //main.h:  MAX_MONEY

    public static final int SMALLEST_UNIT_EXPONENT =  8;

    /**
     * fee :
     * 1 won or
     * 0.1 %
     * minimum pay 500won
     */
    public static final Coin DEFAULT_MIN_TX_FEE = Coin.valueOf(1000);   // MIN_TX_FEE
    public static final Coin DUST_LIMIT = Coin.valueOf(546); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70001;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70000;        //version.h MIN_PROTO_VERSION
    public static final int INIT_PROTO_VERSION = 209;            //version.h

    public static final int GETHEADERS_VERSION = 31800; //CHOI_DEBUG version.h GETHEADERS_VERSION
    public static final int BLOCK_CURRENTVERSION = 3;   //block.h CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000; //block.h MAX_BLOCK_SIZE


    public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }

    public static final int Port    = 47773;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 37773;     //protocol.h GetDefaultPort(testnet=true)

    public static final int RegTestPort = 37774; //18444
    //
    //  Production
    //
    public static final int AddressHeader = 0;            //chainparams.cpp:219 base58Prefixes[PUBKEY_ADDRESS]
    public static final int p2shHeader = 5;               //chainparams.cpp:220 base58Prefixes[SCRIPT_ADDRESS]
    public static final long PacketMagic = 0xf9beb4d9L;  //chainparams.cpp:149 pchMessageStart

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e00ffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1439900675L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (131494949);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = //"b2bcc7ec0c0e05759eb23cbaa47d3606e8f80ac1f58a120cc6bb26f082894c56";
            "00000002c6db9248f6bf4861cf5830ce1182534ffbef67cc9af1c460b44d08b9"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 100000000;
    static public int genesisBlockVersion = 1; //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer

    static public String genesisTxInBytes = "04ffff001e0104465468652054696d65732031382f4175672f323031352049206275696c7420666972737420636f7272656374206d65726b6c65206861736820666f722053656f756c636f696e2e";
    //"04ffff001d0104505468652054696d657320392f4a756c2f323031352053656f756c636f696e2068656c642061206d656574696e672077697468207032706620696e2053656f756c20426974636f696e2043656e7465722e";   //"Digitalcoin, A Currency for a Digital Age"

    static public String genesisTxOutBytes = "04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f";



    //static public String genesisMerkleRoot = "7ac0debb4f141f5a4baa8e05f2e3fa73c33bf69131ed3d81a46af2eac35b0a20";


     // "Pressure must be put on Vladimir Putin over Crimea"


    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "test1.seoulcoin.info","test2.seoulcoin.info","test3.seoulcoin.info"

    };

    public static int minBroadcastConnections = 1;   //0 for default; we need more peers.

    //
    // TestNet
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x0b110907;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = CoinDefinition.genesisHash;
    // "000000d36b5a3fa6998554fe6cf307998b5df14f406b42ba755adc467391a6c5";//"";
    static public long testnetGenesisBlockDifficultyTarget = CoinDefinition.genesisBlockDifficultyTarget;         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = CoinDefinition.genesisBlockTime;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = CoinDefinition.genesisBlockNonce;                         //main.cpp: LoadBlockIndex

    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
//        int COIN = 1;
//        Coin nSubsidy = Coin.valueOf(15, 0);
//        return nSubsidy.shiftRight(height / subsidyDecreaseBlockCount);
        //CHOI_DEBUG
        if (height  <= 100)
            return Coin.valueOf(CoinDefinition.genesisBlockValue);
        else
            return Coin.valueOf(0);
    }
    static final Coin nGenesisBlockRewardCoin = Coin.valueOf(1, 0);
    static final Coin minimumSubsidy = Coin.valueOf(5, 0);
    static final Coin nPremine = Coin.valueOf(1000000000000L);//1 Jowon

    Coin GetBlockSubsidy(int nHeight){

        if (nHeight <= 100) {
            return nPremine;
        }
//        if (nHeight == 0)
//        {
//            return nGenesisBlockRewardCoin;
//        }
//
//        if (nHeight == 1)
//        {
//            return nPremine;
		/*
		optimized standalone cpu miner 	60*512=30720
		standalone gpu miner 			120*512=61440
		first pool			 			70*512 =35840
		block-explorer		 			60*512 =30720
		mac wallet binary    			30*512 =15360
		linux wallet binary  			30*512 =15360
		web-site						100*512	=51200
		total									=240640
		*/
//        }

//        Coin nSubsidy = Coin.valueOf(512);
//
//        // Subsidy is reduced by 6% every 10080 blocks, which will occur approximately every 1 week
//        int exponent=(nHeight / 10080);
//        for(int i=0;i<exponent;i++){
//            nSubsidy=nSubsidy.multiply(47);
//            nSubsidy=nSubsidy.divide(50);
//        }
//        if(nSubsidy.compareTo(minimumSubsidy) < 0) {nSubsidy=minimumSubsidy;}
//        return nSubsidy;
        return Coin.valueOf(0);
    }

    Coin GetBlockSubsidy120000(int nHeight)
    {
        // Subsidy is reduced by 10% every day (1440 blocks)
        Coin nSubsidy = Coin.valueOf(250, 0);
        int exponent = ((nHeight - 120000) / 1440);
        for(int i=0; i<exponent; i++)
            nSubsidy = nSubsidy.multiply(45).divide(50);

        return nSubsidy;
    }

    Coin GetBlockSubsidy150000(int nHeight)
    {
        // Subsidy is reduced by 1% every week (10080 blocks)
        Coin nSubsidy = Coin.valueOf(25, 0);
        int exponent = ((nHeight - 150000) / 10080);
        for(int i=0; i<exponent; i++)
            nSubsidy = (nSubsidy.multiply(99).divide(100));

        return nSubsidy.compareTo(minimumSubsidy) < 0 ? minimumSubsidy : nSubsidy;
    }

    public Coin GetBlockValue(int nHeight)
    {
//        if(nHeight >= 150000)
//            return GetBlockSubsidy150000(nHeight);
//
//        if(nHeight >= 120000)
//            return GetBlockSubsidy120000(nHeight);
        return GetBlockSubsidy(nHeight);
    }

    public static int subsidyDecreaseBlockCount = 210000;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e00ffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "test1.seoulcoin.info"
    };
    //from chainparams.cpp CMainParams::vAlertPubKey
    public static final String SATOSHI_KEY = "04fc9702847840aaf195de8442ebecedf5b095cdbb9bc716bda9110971b28a49e0ead8564ff0db22209e0374782c093bb899692d524e9d6a6956e7c5ecbcd68284";
    //from chainparams.cpp CTestNetParams::vAlertPubKey
    public static final String TESTNET_SATOSHI_KEY = "04302390343f91cc401d56d68b123028bf52e5fca1939df127f63c6467cdf9c8e2c14b61104cf817d0b780da337893ecc4aaff1309e536162dabbdb45200ca2b0a";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.fairpay.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.fairpay.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.fairpay.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0, new Sha256Hash(CoinDefinition.genesisHash));
        checkpoints.put( 500, new Sha256Hash("000000118bb31afec6dadeaf7c0718dc07255e7346570904643bf48b09bc1ed0"));
        checkpoints.put( 10000, new Sha256Hash("00000003ce67abf8ad65687ed50d2f62f70ef76b44f0c00a19e448cc445e1365"));
        checkpoints.put( 11000, new Sha256Hash("000000220ede0cb68c013f92c26c278ac9f17539f6555761a8821bc85c9d55b4"));
        checkpoints.put( 11800, new Sha256Hash("0000003bc725db35104004eec76c69cabd5deffd3e76953687ac659671e88611"));
        ///checkpoints.put( 28888, new Sha256Hash("00000000000228ce19f55cf0c45e04c7aa5a6a873ed23902b3654c3c49884502"));
        //checkpoints.put( 58888, new Sha256Hash("0000000000dd85f4d5471febeb174a3f3f1598ab0af6616e9f266b56272274ef"));
        //checkpoints.put(111111, new Sha256Hash("00000000013de206275ee83f93bee57622335e422acbf126a37020484c6e113c"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "FmpNNw388tMqsDkKW6KfyksRkCVWqjBSCe";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "QU1rjHbrdJonVUgjT7Mncw7PEyPv3fMPvaGXp9EHDs1uzdJ98hUZ";

}

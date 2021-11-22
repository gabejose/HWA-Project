package com.qa.demo;

import com.qa.demo.createTest.CreateBoatClubTest;
import com.qa.demo.createTest.CreateBoatTest;
import com.qa.demo.deleteTest.DeleteBoatClubTest;
import com.qa.demo.deleteTest.DeleteBoatTest;
import com.qa.demo.homeTest.BoatClubHomeTest;
import com.qa.demo.homeTest.BoatHomeTest;
import com.qa.demo.readTest.ReadBoatClubTest;
import com.qa.demo.readTest.ReadBoatTest;
import com.qa.demo.updateTest.UpdateBoatClubTest;
import com.qa.demo.updateTest.UpdateBoatTest;

public class Runner {

	public static void main(String[] args) {
		IndexPageTest index = new IndexPageTest();
		index.setup();
		index.headerTest();
		index.indexTitleTest();
		index.boatLinkTest();
		index.tearDown();
		
		BoatClubHomeTest homeBoatClub = new BoatClubHomeTest();
		homeBoatClub.setup();
		homeBoatClub.headerTest();
		homeBoatClub.linkTest();
		homeBoatClub.readLinkTest();
		homeBoatClub.titleTest();
		homeBoatClub.tearDown();
		
		BoatHomeTest homeBoat = new BoatHomeTest();
		homeBoat.setup();
		homeBoat.boatClubLinkTest();
		homeBoat.goCreateBoatTest();
		homeBoat.headerTest();
		homeBoat.returnToIndexTest();
		homeBoat.titleTest();
		homeBoat.tearDown();
		
		CreateBoatClubTest createBoatClub = new CreateBoatClubTest();
		createBoatClub.setup();
		createBoatClub.h4Test();
		createBoatClub.resetBtnTest();
		createBoatClub.returnToIndexTest();
		createBoatClub.titleTest();
		createBoatClub.tearDown();
		
		CreateBoatTest createBoat = new CreateBoatTest();
		createBoat.setup();
		createBoat.goToDeleteTest();
		createBoat.indexReturnTest();
		createBoat.returnHomeTest();
		createBoat.tearDown();
		
		ReadBoatClubTest readBoatClub = new ReadBoatClubTest();
		readBoatClub.setup();
		readBoatClub.clearTableTest();
		readBoatClub.headerTest();
		readBoatClub.returnHomeTest();
		readBoatClub.titleTest();
		readBoatClub.tearDown();
		
		ReadBoatTest readBoat = new ReadBoatTest();
		readBoat.setup();
		readBoat.checkHeaderTest();
		readBoat.checkTitleTest();
		readBoat.returnIndexTest();
		readBoat.updateLinkTest();
		readBoat.tearDown();
		
		UpdateBoatClubTest updateBoatClub = new UpdateBoatClubTest();
		updateBoatClub.setup();
		updateBoatClub.h4Test();
		updateBoatClub.returnToIndexTest();
		updateBoatClub.titleTest();
		updateBoatClub.updateBtnTest();
		updateBoatClub.tearDown();
		
		UpdateBoatTest updateBoat = new UpdateBoatTest();
		updateBoat.setup();
		updateBoat.createLinkTest();
		updateBoat.headerTest();
		updateBoat.resetBtnTest();
		updateBoat.testTitle();
		updateBoat.tearDown();
		
		DeleteBoatClubTest deleteBoatClub = new DeleteBoatClubTest();
		deleteBoatClub.setup();
		deleteBoatClub.deleteBtnTest();
		deleteBoatClub.returnHomeTest();
		deleteBoatClub.tagsTest();
		deleteBoatClub.titleTest();
		deleteBoatClub.tearDown();
		
		DeleteBoatTest deleteBoat = new DeleteBoatTest();
		deleteBoat.setup();
		deleteBoat.deleteBtnTextTest();
		deleteBoat.h4TextTest();
		deleteBoat.indexReturnTest();
		deleteBoat.titleTest();
		deleteBoat.tearDown();
		
	}

}

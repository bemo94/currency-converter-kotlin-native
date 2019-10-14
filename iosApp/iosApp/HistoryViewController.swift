//
//  ViewController.swift
//  iosApp
//
//  Created by BENNIS MOHAMED on 09/05/2019.
//  Copyright © 2019 Octo. All rights reserved.
//

import UIKit
import SharedCode

class HistoryViewController: UIViewController, HistoryDisplay {
    
    var historyDi: HistoryDi?
    var controller: HistoryController?
    @IBOutlet weak var HistoryTableView: UITableView!
    var items: NSMutableArray = []
    
    func displayHistory(history: NSMutableArray?) {
        items = history!
        HistoryTableView.reloadData()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        HistoryTableView.dataSource = self
        self.historyDi = HistoryDi.init(displayer: self)
        controller = historyDi?.getHistoryController()
        controller?.loadHistory()
    }
    
    @IBAction func close() {
        self.dismiss(animated: true, completion: nil)
    }
    
}

extension HistoryViewController: UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.items.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "HistoryCell") as! HistoryCell
        print("in table view")
        
        let data = items[indexPath.row] as AnyObject
        
        let text: String = data.date + " : " + data.originValue + " " + data.origin + " = " + data.destinationValue + " " + data.destination
        
        cell.item.text = text
        
        return cell
    }
    
}

/*
 * FactorGraph.scala  
 * Factor Graph
 * 
 * Created By:      Glenn Takata (gtakata@cra.com)
 * Creation Date:   Oct 25, 2014
 * 
 * Copyright 2014 Avrom J. Pfeffer and Charles River Analytics, Inc.
 * See http://www.cra.com or email figaro@cra.com for information.
 * 
 * See http://www.github.com/p2t2/figaro for a copy of the software license.
 */

package com.cra.figaro.library.factors.graph

import com.cra.figaro.library.factors._

/**
 * Class for Factor graphs
 */
trait FactorGraph[T] {
 
  /**
   * Returns a uniform factor 
   */
  def uniformFactor(v: List[Variable[_]]): Factor[T]
  
  /**
   * Returns true if the graph contains a node for a (single) variable
   */
  def contains(v: Node): Boolean
  
  /**
   * Returns all nodes in the factor graph
   */
  def getNodes(): Iterable[Node]
  
  /**
   * Returns all neighbors of a given node
   */
  def getNeighbors(source: Node): Iterable[Node]

  /**
   * Returns all neighbors of a given node excluding the node of the second argument
   */
  def getNeighbors(source: Node, excluding: Node): Iterable[Node]
    
  /**
   * Gets the factor for a particular factor node
   */
  def getFactorForNode(fn: FactorNode): Factor[T]
  
  /**
   * Get a list of messages to the node
   */
  def getMessagesForNode(node: Node): Iterable[(Node, Factor[T])]
  
  /**
   * Gets the last message to a node from another
   */
  def getLastMessage(from: Node, to: Node): Factor[T]
  
  /**
   * Updates the factor graph with a message from a node to another.
   * Returns a new factor graph, which can be the same as this one.
   */
  def update(from: Node, to: Node, f: Factor[T]): FactorGraph[T]
  
}